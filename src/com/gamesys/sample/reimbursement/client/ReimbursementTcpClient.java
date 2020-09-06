package com.gamesys.sample.reimbursement.client;

import com.gamesys.sample.reimbursement.core.ReimbursementService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ReimbursementTcpClient {

    private final ReimbursementService reimbursementService;

    public ReimbursementTcpClient(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    public void execute() {
        try (ServerSocket serverSocket = new ServerSocket(3300)) {
            do {
                Socket socket = serverSocket.accept();
                ReimbursementTcpHandler tcpHandler = new ReimbursementTcpHandler(socket, reimbursementService);
                Thread thread = new Thread(tcpHandler);
                thread.start();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
