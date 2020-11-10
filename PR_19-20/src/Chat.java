import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;
import java.io.PrintWriter;
import java.text.*;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(1337);
        System.out.println("Chat is running!");
        PrintWriter writer = new PrintWriter("D:\\IJ проекты\\PR_19-20\\history.txt");
        String catchMessage;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nickname: ");
        String nickname = scanner.nextLine();

        while (true) {
            String mes = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            Date dateNow = new Date();
            String fullMessage = formatter.format(dateNow) + " | " + nickname + ": " + mes;

            byte[] data = fullMessage.getBytes();
            DatagramPacket packetToSend = new DatagramPacket(
                    data,
                    0, data.length,
                    InetAddress.getByName("255.255.255.255"),
                    1337
            );
            socket.send(packetToSend);

            try {
                byte[] bufferForReceive = new byte[2024];
                DatagramPacket packetToReceive = new DatagramPacket(
                        bufferForReceive,
                        0,
                        bufferForReceive.length);
                socket.receive(packetToReceive);
                catchMessage = new String(packetToReceive.getData(), 0, packetToReceive.getLength());
                String[] mass = catchMessage.split(" ");
                writer.write(catchMessage + "\n");
                writer.flush();
                System.out.println(catchMessage);
            }
            finally {

            }
        }
    }
}