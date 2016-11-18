package banco.negocio.basedatos.sqlite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import banco.negocio.basedatos.sqlite.dto.ClienteDTO;
import banco.negocio.basedatos.sqlite.dto.TransaccionDTO;
import banco.negocio.basedatos.sqlite.interfaz.IBancoDAO;

public class SQLiteBancoDAO implements IBancoDAO {
	private boolean keepConnection;
	private String ROUTE = "./Banco";
	private Connection conexion;
	
	public SQLiteBancoDAO(boolean keepConnection){
		this.keepConnection = keepConnection;
		
		try{
			Class.forName("org.sqlite.JDBC");
			
			conexion = DriverManager.getConnection("jdbc:sqlite:"+ROUTE);
			System.out.println("Conexion establecida");
		}catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	@Override
	public void agregarCliente(ClienteDTO cliente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<ClienteDTO> listarClientes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(ClienteDTO cliente) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarTransaccion(ClienteDTO cliente, TransaccionDTO transaccion) throws Exception {
		try{
			String SQL = "";
			
			PreparedStatement pst = conexion.prepareStatement(SQL);
			pst.setInt(1, transaccion.getTipo());
			pst.setInt(2, transaccion.getCantidad());
			
			pst.executeUpdate();
		}catch (Exception e) {
			throw new Exception(e);
		}finally{
			if(!keepConnection)
				if(conexion != null)
					conexion.close();
		}
	}

	@Override
	public ArrayList<TransaccionDTO> listarTransacciones(ClienteDTO cliente) throws Exception {
		ArrayList<TransaccionDTO> list = null;
		
		try{
			String SQL = "SELECT Transaccion.tipo, Transaccion.cantidad FROM Cliente INNER JOIN Transaccion ON Cliente.id_cliente = Transaccion.id_cliente WHERE Cliente.documento = "+cliente.getDocumento();
			PreparedStatement pst = conexion.prepareStatement(SQL);
			ResultSet rs = pst.executeQuery();
			
			list = new ArrayList<>();
			
			while(rs.next()){
				TransaccionDTO tDTO = new TransaccionDTO();
				
				tDTO.setTipo(rs.getInt(1));
				tDTO.setCantidad(rs.getInt(2));
				
				list.add(tDTO);
			}
			
			rs.close();
		}catch (Exception e) {
			list = null;
			throw new Exception(e);
		}finally{
			if(!keepConnection)
				if(conexion != null)
					conexion.close();
		}
		
		return list;
	}
}
