package banco.negocio.basedatos.sqlite.dto;

public class ClienteDTO {
	private int documento;
	private String nombre;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(int documento, String nombre){
		this.documento = documento;
		this.nombre = nombre;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
