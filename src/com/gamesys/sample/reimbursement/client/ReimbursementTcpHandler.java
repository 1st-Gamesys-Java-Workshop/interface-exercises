package com.gamesys.sample.reimbursement.client;

import com.gamesys.sample.reimbursement.core.ReimbursementService;
import com.gamesys.sample.reimbursement.utils.InputUtils;

import java.io.*;
import java.math.BigDecimal;
import java.net.Socket;

public class ReimbursementTcpHandler implements Runnable {

    private final Socket socket;
    private final InputStream inputStream;
    private final InputStreamReader inputStreamReader;
    private final BufferedReader bufferedReader;
    private final OutputStream outputStream;
    private final PrintWriter printWriter;
    private final ReimbursementService reimbursementService;

    public ReimbursementTcpHandler(Socket socket, ReimbursementService reimbursementService) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        outputStream = socket.getOutputStream();
        printWriter = new PrintWriter(outputStream);
        this.reimbursementService = reimbursementService;
    }

    @Override
    public void run() {
        printWriter.println("Enter reimbursement data in the following format:");
        printWriter.println("<item name>,<amount>,<receipt URL>");

        String input = getInput();

        if (!ReimbursementClient.isValid(input)) {
            String[] data = input.split(",");
            if (InputUtils.isAnAmount(data[1])) {
                reimbursementService.reimburse(data[0], new BigDecimal(data[1]), data[2]);
                printWriter.println("Reimbursement saved!");
            }
        }
    }

    private String getInput() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    @Override
    protected void finalize() throws Throwable {
        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
    }
}
