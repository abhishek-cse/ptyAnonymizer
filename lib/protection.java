import java.io.BufferedReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import com.protegrity.Protector;
import com.protegrity.ProtectorException;
import com.protegrity.SessionObject;

public class protection {

		public static void main(String[] args) throws  IOException, ProtectorException {
			String[] input = args[0];
			String deName = args[1];
			String[] protectedOutput = new String[input.length];
			String user =args[2];
			 
			Protector protector = null;
				try {
					protector = Protector.getProtector();
				}catch (ProtectorException e){
					e.printStackTrace();
					throw e;
				}
			SessionObject session = protector.createSession(user);
			if (!protector.protect(session, deName, input, protectedOutput))
					System.out.println("Protect API failed" + protector.getLastError(session));
				
				System.out.println("the output is" );
				for (int i = 0; i< protectedOutput.length; i++){
					System.out.println("Protected value" + (protectedOutput[i]));
				}
				
		}
		

}