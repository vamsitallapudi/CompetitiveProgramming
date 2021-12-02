import java.io.*;
import java.util.*;

class Node {
    int value;
    Node next;

    public Node(int val) {
        this.value = val;
        this.next = null;
    }

    public Node(int val, Node next) {
        this.value = val;
        this.next = next;
    }
}

public class LinkedListPractice {
    private static void printLLRev(Node n) {
        if (n.next != null) {
            Node temp = n.next;
            printLLRev(temp);
        }
        System.out.println(n.value);
    }

    private static void reverse(Node node) {
        if (node.next != null && node.next.next != null) {
            reverse(node.next);
        }
        node.next = node;
    }

    private static void printLL(Node n) {
        System.out.println(n.value);
        if (n.next != null) {
            Node temp = n.next;
            printLL(temp);
        }
    }

    private static void insertInMiddle(Node first, Node newNode) {
        Node slowPtr = first;
        Node fastPtr = first;
        while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        newNode.next = slowPtr.next;
        slowPtr.next = newNode;
        printLL(first);
    }

    private static void solve() throws IOException {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println("Printing LL");
        printLL(node);
        System.out.println("Printing LL in reverse");
        printLLRev(node);
        System.out.println("Inserting in middle");
        insertInMiddle(node, new Node(7));
        System.out.println("Reversing a LL");
        reverse(node);
        printLL(node);

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static Reader sc = new Reader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        /*
         * For integer input: int n=inputInt(); For long input: long n=inputLong(); For
         * double input: double n=inputDouble(); For String input: String
         * s=inputString(); Logic goes here For printing without space: print(a+"");
         * where a is a variable of any datatype For printing with space: printSp(a+"");
         * where a is a variable of any datatype For printing with new line:
         * println(a+""); where a is a variable of any datatype
         */

        solve();
        bw.flush();
        bw.close();
    }

    public static int inputInt() throws IOException {
        return sc.nextInt();
    }

    public static long inputLong() throws IOException {
        return sc.nextLong();
    }

    public static double inputDouble() throws IOException {
        return sc.nextDouble();
    }

    public static String inputString() throws IOException {
        return sc.readLine();
    }

    public static void print(String a) throws IOException {
        bw.write(a);
    }

    public static void printSp(String a) throws IOException {
        bw.write(a + " ");
    }

    public static void println(String a) throws IOException {
        bw.write(a + "\n");
    }
}
