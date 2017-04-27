package cat.torralbo.biblioteca;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Max on 30/03/2017.
 */
public class Llibres {

    ArrayList<Llibres> use = new ArrayList<Llibres>();

    Scanner sc = new Scanner(System.in);

    private int id;
    private String titol;
    private int editorial;
    private int autor;
    private int tema;
    private java.util.Date dataPublicacio;
    private String idioma;
    private boolean segueix;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public Date getDataPublicacio() {
        return dataPublicacio;
    }

    public void setDataPublicacio(Date dataPublicacio) {
        this.dataPublicacio = dataPublicacio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void crearLlibre(){
        //Comprovem que no hi hagi llibres i en creem un per defecte.
        if(use.size() == 0) {
            Llibres llibres = new Llibres();
            Date data = new Date();

            llibres.setId(1);
            llibres.setTitol("El tresor que tothom cerca");
            llibres.setEditorial(1);
            llibres.setAutor(1);
            llibres.setTema(1);
            llibres.setDataPublicacio(data);
            llibres.setIdioma("Català");

            use.add(llibres);
        }
    }

    public void crear() {
        //creació objecte
        Llibres llibres = new Llibres();
        Date data = new Date();

        //id automàtica segons la posicio a l'arrayList
        llibres.setId(use.size()+1);

        do {
            try {
                System.out.print("Entra el títol: ");
                llibres.setTitol(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra l'editorial: ");
                llibres.setEditorial(Integer.parseInt(sc.nextLine()));
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra l'autor: ");
                llibres.setAutor(Integer.parseInt(sc.nextLine()));
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra el tema: ");
                llibres.setTema(Integer.parseInt(sc.nextLine()));
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);



        llibres.setDataPublicacio(data);

        do {
            try {
                System.out.print("Entra l'idioma: ");
                llibres.setIdioma(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);


        //afegim l'objecte a l'arraylist
        use.add(llibres);

    }

    public void modificar() {
        //crear objecte
        Llibres llibres = new Llibres();
        String llibreModificar = null;

        //Comprovem que existeixi el llibre
        do {
            try {
                System.out.print("\nQuin és el títol del llibre que vols modificar?: ");
                llibreModificar = sc.nextLine();

                if(!existeixLlibre(llibreModificar)){
                    throw new Exception();
                }

                segueix = false;
            } catch (Exception e) {
                System.out.print("Aquest llibre no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default:
                        System.out.println();
                        Menu menu = new Menu();
                        menu.gestiollibres(); break;
                }
            }
        } while (segueix);

        int idModificar = 0;
        for (Llibres objecte : use) {

            if(llibreModificar.equals(objecte.getTitol())){
                idModificar = objecte.getId();
                llibres.setDataPublicacio(objecte.getDataPublicacio());
            }

        }


        do {
            try {
                System.out.print("Entra el títol: ");
                llibres.setTitol(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra l'editorial: ");
                llibres.setEditorial(Integer.parseInt(sc.nextLine()));
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra l'autor: ");
                llibres.setAutor(Integer.parseInt(sc.nextLine()));
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra el tema: ");
                llibres.setTema(Integer.parseInt(sc.nextLine()));
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        do {
            try {
                System.out.print("Entra l'idioma: ");
                llibres.setIdioma(sc.nextLine());
                segueix = false;
            } catch (Exception e) {
                System.out.print("Hi ha hagut un problema.\n");
                segueix = true;
            }
        } while (segueix);

        //modifiquem l'objecte amb la id anterior
        use.set(idModificar-1,llibres);

    }

    public void eliminar() {
        String llibreEliminar = null;

        //Comprovem que existeixi el llibre
        do {
            try {
                System.out.print("Quin és el títol del llibre que vols eliminar?: ");
                llibreEliminar = sc.nextLine();

                if(!existeixLlibre(llibreEliminar)){
                    throw new Exception();
                }

                segueix = false;
            } catch (Exception e) {
                System.out.print("Aquest llibre no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }
        } while (segueix);

        int indexEliminar = 0;
        for (Llibres objecte : use) {

            if(llibreEliminar.equals(objecte.getTitol())){

                indexEliminar = (objecte.getId()-1);
            }

        }

        //eliminem el llibre de la posicio de l'array que s'ha establert anteriorment
        use.remove(indexEliminar);
    }

    public void consultar() {
        //creació de l'objecte
        Llibres llibres = new Llibres();
        String titolConsultar = null;

        //Comprovem que existeixi el llibre
        do {
            try {
                System.out.print("Quin títol vols consultar?: ");
                titolConsultar = sc.nextLine();

                if(!existeixLlibre(titolConsultar)){
                    throw new Exception();
                }

                segueix = false;
            } catch (Exception e) {
                System.out.print("Aquest llibre no existeix.\n");
                System.out.print("\nEscrigui (S) per a continuar buscant, (intro) per a tornar enrere: ");
                String opcio = sc.nextLine().toUpperCase();
                switch (opcio){
                    case "S": segueix = true; break;
                    default: segueix = false; break;
                }
            }
        } while (segueix);


        for (Llibres objecte : use) {

            Menu menu = new Menu();

            if(titolConsultar.equals(objecte.getTitol())){
                System.out.println("\nLa id del llibre és: "+ objecte.getId());
                System.out.println("El títol del llibre és: "+ objecte.getTitol());
                System.out.println("L'editorial és: "+ menu.editorial.nomPerId(objecte.getId()));
                System.out.println("L'autor és: "+ menu.autor.nomPerId(objecte.getId()));
                System.out.println("El tema del llibre és: "+ menu.tema.nomPerId(objecte.getId()));
                System.out.println("La data de publicació és: "+ objecte.getDataPublicacio());
                System.out.println("L'idioma del llibre és: "+ objecte.getIdioma());
            }

        }
    }

    /*
       Comprovem si existeix el llibre
    */
    public boolean existeixLlibre(String titol){

        boolean existeix = false;

        //recorre tots els llibres fins que coincideixi el títol
        for (Llibres objecte : use) {
            if(titol.equals(objecte.getTitol())){
                existeix = true;
            }

        }

        return existeix;
    }

}
