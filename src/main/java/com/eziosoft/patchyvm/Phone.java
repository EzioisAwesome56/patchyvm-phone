package com.eziosoft.patchyvm;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Phone {

    public static void main(String[] args) throws IOException {
        // do the haha funny here
        if (args.length < 1){
            System.out.println("PatchyVM-phone copyright 2021 eziosoft llc");
            System.out.println("usage:");
            System.out.println("patchyvm.jar <host> <port> <hostname>");
            System.out.println("<host>: ip of phone home server");
            System.out.println("<port>: port of phone home server");
            System.out.println("<hostname>: system hostname (put $HOSTNAME and it should work)");
            System.exit(-1);
        }
        // create the connection
        Socket s = new Socket(args[0], Integer.parseInt(args[1]));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        // write host name
        out.writeUTF(args[2]);
        // die
        out.close();
        s.close();
        return;
    }
}
