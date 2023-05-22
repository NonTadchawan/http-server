package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HttpServer {
    public void start() throws IOException {
        ServerSocket serverSocket =new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(()->{
                try {BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter writer =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String readLine = reader.readLine();
                    System.out.println(readLine);
                    String method = readLine.split(" ")[0];
                    String resourceUrl = readLine.split(" ")[1];
                    System.out.println("method: "+method);
                    System.out.println("resourceUrl: "+resourceUrl);

                    writer.write("HTTP/1.1 200");
                    writer.newLine();
                    writer.newLine();
                    writer.write("<html><body>Hello!</body></html>");
                    writer.flush();
                    socket.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();

        }
    }
}
