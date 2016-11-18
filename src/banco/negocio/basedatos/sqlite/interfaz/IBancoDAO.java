package banco.negocio.basedatos.sqlite.interfaz;

import java.util.ArrayList;

import banco.negocio.basedatos.sqlite.dto.ClienteDTO;
import banco.negocio.basedatos.sqlite.dto.TransaccionDTO;

public interface IBancoDAO {
	public void agregarCliente(ClienteDTO cliente) throws Exception;
	public ArrayList<ClienteDTO> listarClientes() throws Exception;
	public void eliminarCliente(ClienteDTO cliente) throws Exception;
	
	public void agregarTransaccion(ClienteDTO cliente, TransaccionDTO transaccion) throws Exception;
	public ArrayList<TransaccionDTO> listarTransacciones(ClienteDTO cliente) throws Exception;
}
