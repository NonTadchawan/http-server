package org.example.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.31.56",8080);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("GET http://localhost:8080");
        writer.newLine();
        writer.flush();

        String s = reader.readLine();
        System.out.println(s);
        socket.close();
    }
}
