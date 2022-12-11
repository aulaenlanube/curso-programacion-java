class HolaMundo {
	public static void main(String[] args) {
    	  if (args.length > 1) {
          	for (int i = 0; i < Integer.parseInt(args[1]); i++)
              	System.out.println("Hola " + args[0]);       	 
    	  }
    	  else System.out.println("Hola mundo simple");	}
}
