import java.io.BufferedReader;
import java.io.InputStreamReader;

//Añadido: Carácteres especiales en CONTRASEÑA
public class Generador {
 
	public static String NUMEROS = "0123456789";
 
	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
 
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
 
	public static String ESPECIALES = "ñÑ*";
 
	
	public String getPinNumber() {
		return getPassword(NUMEROS, 4);
	}
 
	public String getPassword(int length) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES, length);
	}
 
	public String getPassword(String key, int length) {
		String pswd = "";
 
		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}
 
		return pswd;
    }
    
    public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		Generador g = new Generador();
		try{		
			System.out.println("¿Que quieres generar un pin o una contraseña?: (PIN/CONTRASEÑA)");
			String cadena = br.readLine();
			String pass = "";
			if(cadena.equals("PIN")){
				pass = g.getPinNumber();
			}
			else if(cadena.equals("CONTRASEÑA")){
				System.out.println("Introduce el tamaño que quieres que tenga la CONTRASEÑA:");
				String tamaño = br.readLine();
				pass = g.getPassword(Integer.parseInt(tamaño));
			}else{
				System.out.println("Saliendo...");
				return;
			}
			System.out.println("Solución:");
			System.out.println(pass);

		}catch(Exception e){
			System.err.println("Error de caracteres");
		}
    }
}
 
   
