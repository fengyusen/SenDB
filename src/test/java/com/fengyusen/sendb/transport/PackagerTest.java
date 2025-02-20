package com.fengyusen.sendb.transport;

import com.fengyusen.sendb.backend.utils.Panic;
import org.junit.Test;

import java.net.ServerSocket;
import java.net.Socket;

public class PackagerTest {
    @Test
    public void testPackager() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket ss = new ServerSocket(10345);
                    Socket socket = ss.accept();
                    Transporter t = new Transporter(socket);
                    Encoder e = new Encoder();
                    Packager p = new Packager(t, e);
                    com.fengyusen.sendb.transport.Package one = p.receive();
                    assert "pkg1 test".equals(new String(one.getData()));
                    com.fengyusen.sendb.transport.Package two = p.receive();
                    assert "pkg2 test".equals(new String(two.getData()));
                    p.send(new com.fengyusen.sendb.transport.Package("pkg3 test".getBytes(), null));
                    ss.close();
                } catch (Exception e) {
                    Panic.panic(e);
                }    
            }
        }).start();
        Socket socket = new Socket("127.0.0.1", 10345);
        Transporter t = new Transporter(socket);
        Encoder e = new Encoder();
        Packager p = new Packager(t, e);
        p.send(new com.fengyusen.sendb.transport.Package("pkg1 test".getBytes(), null));
        p.send(new com.fengyusen.sendb.transport.Package("pkg2 test".getBytes(), null));
        Package three = p.receive();
        assert "pkg3 test".equals(new String(three.getData()));
    }
}
