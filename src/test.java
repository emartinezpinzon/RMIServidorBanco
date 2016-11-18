import java.util.ArrayList;

import javax.sql.rowset.serial.SerialArray;

import banco.negocio.basedatos.sqlite.dao.SQLiteBancoDAO;
import banco.negocio.basedatos.sqlite.dto.TransaccionDTO;

public class test {
	public static void main(String [] emp){
		SQLiteBancoDAO sql = new SQLiteBancoDAO(true);
		
		try {
			ArrayList<TransaccionDTO> list = sql.verTransacciones(1);
			
			for (TransaccionDTO transaccionDTO : list) {
				System.out.println("Tipo "+transaccionDTO.getTipo()+" cantidad "+transaccionDTO.getCantidad());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
