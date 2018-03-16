/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.webserverhttp;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author 2115237
 */
public class HTTPServer {
    public static void main(String[] args) throws IOException {
       
            ServerSocket serverSocket = null;
            Socket clientSocket = null;
            try {
                serverSocket = new ServerSocket(new Integer(System.getenv("PORT")));
            } catch (IOException e) {
                System.err.println("Could not listen on port");
                System.exit(1);
            }
         while(true){
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            RequestHandle rh = new RequestHandle(clientSocket);
            rh.start();
        }
    }
        
}
