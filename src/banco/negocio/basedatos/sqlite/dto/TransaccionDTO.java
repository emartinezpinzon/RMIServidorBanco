package banco.negocio.basedatos.sqlite.dto;

public class TransaccionDTO {
	private int tipo, cantidad;
	
	public TransaccionDTO(){
		
	}
	
	public TransaccionDTO(int tipo, int cantidad){
		this.tipo = tipo;
		this.cantidad = cantidad;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}