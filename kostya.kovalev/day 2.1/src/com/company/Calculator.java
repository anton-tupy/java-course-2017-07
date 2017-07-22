package com.company;

import java.io.*;

/**
 * Created by Natalya on 20.07.2017.
 */
public class Calculator {

        public void run (String path){
            LineParser lineParser= new LineParser();

            CommandFactory commandFactory= new CommandFactory();
            CalculatorContext calculatorContext = new CalculatorContext();
            BufferedReader reader=getBufferedReader(path);
            String line=null;

            while(true) {
                try {
                    line= reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if(line==null){
                   break;
               }
               ParseResult parseResult = lineParser.parse(line);
                if (parseResult==null){
                    continue;
                }
                Command command = commandFactory.createCommand(parseResult.getCommandName());     // передаем комманду из файла
                command.execute(parseResult.getArguments(),calculatorContext);                    //передаем аргумент и что сделать из pop push итд
            }



        }

        private BufferedReader getBufferedReader(String path){
            return new BufferedReader(getReader(path));
    }


        private Reader getReader(String path)  {
            if(path==null){
               return new InputStreamReader(System.in);//реализует интерфейс ридер
            } else {
                try {
                    FileInputStream fileInputStream = new FileInputStream(path);
                    return new InputStreamReader(fileInputStream);

                }
                catch (IOException e){                  //
                    throw new RuntimeException(e);
                }
            }
        }
    }


