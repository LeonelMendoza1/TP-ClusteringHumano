package ClusteringHumano;

public class Persona {
	private String nombre;
	private int deportes, musica, espectaculo, ciencia;

	public Persona(String nombre, int deportes, int musica, int espectaculo, int ciencia) {
		this.nombre = nombre;
		this.deportes = deportes;
		this.musica = musica;
		this.espectaculo = espectaculo;
		this.ciencia = ciencia;
	}
	
	//Para calcular similaridad entre personas
	public int similaridad(Persona persona) {
		int resultado = Math.abs(deportes - persona.getDeportes()) + Math.abs(musica - persona.getMusica()) + 
				Math.abs(espectaculo - persona.getEspectaculo()) + Math.abs(ciencia - persona.getCiencia());
		return (resultado);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDeportes() {
		return deportes;
	}

	public void setDeportes(int deportes) {
		this.deportes = deportes;
	}

	public int getMusica() {
		return musica;
	}

	public void setMusica(int musica) {
		this.musica = musica;
	}

	public int getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(int espectaculo) {
		this.espectaculo = espectaculo;
	}

	public int getCiencia() {
		return ciencia;
	}

	public void setCiencia(int ciencia) {
		this.ciencia = ciencia;
	}
}