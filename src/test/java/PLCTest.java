import com.cn.ucasp.net.CpuType;
import com.cn.ucasp.net.DataType;
import com.cn.ucasp.net.S7TCPConnection;
import com.cn.ucasp.net.VarType;
import org.junit.Test;

import java.io.IOException;

/**
 * PLC
 *
 * @Author janus
 * @Date 15:17 2017/12/6
 * @Description
 */
public class PLCTest {

    @Test
    public void readData() {
        try {
            S7TCPConnection connection = new S7TCPConnection()
                    .withIp("10.25.157.90")
                    .withPort(102)
                    .withCpu(CpuType.S71500)
                    .Open();
            System.out.println(connection.getErrorCode());
            Object object=connection.Read(DataType.DataBlock, 902, 0, VarType.S7Real, 1);

//            Object in=connection.Read("DB902.DBD0");
//            Object in2=connection.Read("DB902.DBD4");
//            Object in3=connection.Read("DB902.DBD8");
//            System.out.println(in+"--"+in2+"--"+in3);
            System.out.println(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writeData() {
        try {
            S7TCPConnection connection = new S7TCPConnection()
                    .withIp("10.25.157.90")
                    .withPort(2000)
                    .withCpu(CpuType.S71500)
                    .Open();

            connection.Write("DB903.DBD0",10);
            Object in=connection.Read("DB903.DBB0");
            System.out.println(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
