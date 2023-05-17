package pwt.projetwebtransact;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pwt.projetwebtransact.Entities.*;
import pwt.projetwebtransact.Repositories.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ProjetWebTransactApplication {
    private final VilleRepository villeRepository;
    private final EtablissementRepository etablissementRepository;
    private final SalleRepository salleRepository;
    private final CoursRepository coursRepository;
    private final SpecialiteRepository specialiteRepository;
    private final PresentationRepository presentationRepository;
    private final SeanceRepository seanceRepository;
    private final CouponRepository couponRepository;
    private static final Random random = new Random();

    public ProjetWebTransactApplication(VilleRepository villeRepository, EtablissementRepository etablissementRepository, SalleRepository salleRepository, CoursRepository coursRepository, SpecialiteRepository specialiteRepository, PresentationRepository presentationRepository, SeanceRepository seanceRepository, CouponRepository couponRepository) {
        this.villeRepository = villeRepository;
        this.etablissementRepository = etablissementRepository;
        this.salleRepository = salleRepository;
        this.coursRepository = coursRepository;
        this.specialiteRepository = specialiteRepository;
        this.presentationRepository = presentationRepository;
        this.seanceRepository = seanceRepository;
        this.couponRepository = couponRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProjetWebTransactApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Faker faker = new Faker();

                // Créer de nouvelles villes
                List<Ville> villes = new ArrayList<Ville>();
                Ville ville1 = new Ville("Montréal");
                villes.add(ville1);

                Ville ville2 = new Ville("New-York");
                villes.add(ville2);

                Ville ville3 = new Ville("Toronto");
                villes.add(ville3);


                // Créer de nouveaux établissements et les ajouter aux villes
                List<Etablissement> etablissements = new ArrayList<Etablissement>();
                Etablissement e1 = new Etablissement(100, "Centre communautaire", ville1);
                etablissements.add(e1);
                Etablissement e2 = new Etablissement(110, "Maison des jeunes", ville1);
                etablissements.add(e2);
                Etablissement e3 = new Etablissement(120, "Hotel de ville", ville1);
                etablissements.add(e3);
                List<Etablissement> ville1Etablissements = new ArrayList<>();
                ville1Etablissements.add(e1);
                ville1Etablissements.add(e2);
                ville1Etablissements.add(e3);
                ville1.setEtablissements(ville1Etablissements);

                Etablissement e4 = new Etablissement(130, "Jardins Mercier", ville2);
                etablissements.add(e4);
                Etablissement e5 = new Etablissement(140, "Centre des bénévoles", ville2);
                etablissements.add(e5);
                List<Etablissement> ville2Etablissements =  new ArrayList<>();
                ville2Etablissements.add(e4);
                ville2Etablissements.add(e5);
                ville2.setEtablissements(ville2Etablissements);

                Etablissement e6 = new Etablissement(150, "Maison communautaires", ville3);
                etablissements.add(e6);
                Etablissement e7 = new Etablissement(160, "Jardins du peuple", ville3);
                etablissements.add(e7);
                Etablissement e8 = new Etablissement(170, "Centre utilitaire", ville3);
                etablissements.add(e8);
                List<Etablissement> ville3Etablissements = new ArrayList<>();
                ville3Etablissements.add(e6);
                ville3Etablissements.add(e7);
                ville3Etablissements.add(e8);
                ville3.setEtablissements(ville3Etablissements);

                // Créer de nouvelles salles et les ajouter
                List<Salle> salles = new ArrayList<>();
                Salle s1 = new Salle(001, "Salle Murphy", e1);
                salles.add(s1);
                Salle s2 = new Salle(002, "Salle Marier", e1);
                salles.add(s2);
                List<Salle> e1Salles = new ArrayList<>();
                e1Salles.add(s1);
                e1Salles.add(s2);
                e1.setSalles(e1Salles);

                Salle s3 = new Salle(003, "Salle Boisvert", e2);
                salles.add(s3);
                Salle s4 = new Salle(004, "Salle Amine", e2);
                salles.add(s4);
                List<Salle> e2Salles = new ArrayList<>();
                e2Salles.add(s3);
                e2Salles.add(s4);
                e2.setSalles(e2Salles);


                // Déclarer des spécialités
                List<Specialite> specialites = new ArrayList<>();
                Specialite sp1 = new Specialite(403, "Informatique");
                specialites.add(sp1);
                Specialite sp2 = new Specialite(420, "Science");
                specialites.add(sp2);
                Specialite sp3 = new Specialite(540, "Langue");
                specialites.add(sp3);
                Specialite sp4 = new Specialite(394, "Éducation");
                specialites.add(sp4);

                // Déclarer des cours
                List<Cours> cours = new ArrayList<>();
                Cours c1 = new Cours(1001, "Introduction à l'informatique", "Notions de base de l'informatique", 3, 3, sp1);
                Cours c2 = new Cours(1002, "Programmation avancée", "Notions plus approfondies", 4, 4, sp1);
                cours.add(c1);
                cours.add(c2);

                Cours c3 = new Cours(1003, "Science politique", "Intro. à la politique", 2, 3, sp2);
                Cours c4 = new Cours(1004, "Biologie", "Cours de biologie", 4, 3, sp2);
                cours.add(c3);
                cours.add(c4);

                Cours c5 = new Cours(1005, "Francais", "La langue francaise", 2, 3, sp3);
                Cours c6 = new Cours(1006, "Anglais", "La langue anglaise", 3, 3, sp3);
                cours.add(c5);
                cours.add(c6);

                Cours c7 = new Cours(1007, "Dépendance chez les jeunes", "Études du comportement des dépendants", 3, 4, sp4);
                Cours c8 = new Cours(1008, "Petite enfance", "Éducation des petits", 2, 2, sp4);
                cours.add(c7);
                cours.add(c8);


                List<Presentation> presentations = new ArrayList<>();
                for (Cours currentCours : cours) {
                    for (Salle currentSalle: salles) {
                        Presentation newPresentation = new Presentation(currentSalle, currentCours);

                        // Add the presentation to the cours
                        List<Presentation> presentationsCours = currentCours.getPresentations();
                        presentationsCours.add(newPresentation);
                        currentCours.setPresentations(presentationsCours);

                        // Add the presentation to the salle
                        Collection<Presentation> presentationsSalle = currentSalle.getPresentations();
                        presentationsSalle.add(newPresentation);
                        currentSalle.setPresentations(presentationsSalle);
                        presentations.add(newPresentation);
                    }
                }

                List<Seance> seances = new ArrayList<>();
                for (Presentation presentation : presentations) {
                    Seance seance = new Seance(random(2, 1000), String.valueOf(LocalTime.of(random(0, 23), random(0, 59), random(0, 59))));
                    seance.setPresentation(presentation);
                    presentation.setSeance(seance);
                    seances.add(seance);
                }

                List<Coupon> coupons = new ArrayList<>();
                for (Presentation presentation : presentations) {
                    List<Coupon> presentationCoupons = new ArrayList<>();
                    // Créer des coupons réservés
                    for (int i = 1; i < random(4, 10); i++) {
                        Coupon newCoupon = new Coupon();
                        newCoupon.setCode(random(1000, 10000));
                        newCoupon.setNomClient(faker.name().fullName());
                        newCoupon.setTarif(faker.number().randomDouble(2, 5, 10));
                        newCoupon.setCodePaiement(random(10000, 40000));
                        newCoupon.setReserve(true);
                        newCoupon.setPresentation(presentation);
                        presentationCoupons.add(newCoupon);
                        coupons.add(newCoupon);
                    }

                    // Créer des coupons non-réservés
                    for (int i = 1; i < random(4, 10); i++) {
                        Coupon newCoupon = new Coupon();
                        newCoupon.setCode(random(1000, 10000));
                        newCoupon.setNomClient("");
                        newCoupon.setTarif(faker.number().randomDouble(2, 5, 10));
                        newCoupon.setCodePaiement(0);
                        newCoupon.setReserve(false);
                        newCoupon.setPresentation(presentation);
                        presentationCoupons.add(newCoupon);
                        coupons.add(newCoupon);
                    }

                    presentation.setCoupons(presentationCoupons);
                }

                villeRepository.saveAll(villes);
                etablissementRepository.saveAll(etablissements);
                salleRepository.saveAll(salles);
                specialiteRepository.saveAll(specialites);
                coursRepository.saveAll(cours);
                presentationRepository.saveAll(presentations);
                seanceRepository.saveAll(seances);
                couponRepository.saveAll(coupons);

                //Salle s5 = new Salle(005, "Salle Farida");

/*

                for (Ville ville:villes) {
                    List<Etablissement> villeEtablissements = new ArrayList<Etablissement>();
                    for (int i = 0; i < random(4, 14); i++) {
                        Etablissement newEtablissement =  new Etablissement(Integer.parseInt(faker.address().buildingNumber()), faker.address().streetName());
                        newEtablissement.setVille(ville);
                        etablissements.add(newEtablissement);
                        villeEtablissements.add(newEtablissement);
                    }
                    ville.setEtablissements(villeEtablissements);
                }

                List<Salle> salles = new ArrayList<Salle>();
                int numberOfSalles = random(3, 15);
                for (Etablissement etablissement:etablissements) {
                    List<Salle> etablissementSalles = new ArrayList<>();
                    for (int i = 0; i < numberOfSalles; i++) {
                        Salle newSalle = new Salle(i + 100, faker.address().streetName());
                        newSalle.setEtablissement(etablissement);
                        salles.add(newSalle);
                        etablissementSalles.add(newSalle);
                    }
                    etablissement.setSalles(etablissementSalles);
                }

                List<Specialite> specialites = new ArrayList<Specialite>();
                for (int j = 0; j < numberOfSalles; j++) {
                    Specialite newSpecialite = new Specialite(j + 100, faker.job().field());
                    specialites.add(newSpecialite);
                }

                List<Cours> cours = new ArrayList<>();
                for (int i = 0; i < numberOfSalles; i++) {
                    Cours newCours = new Cours(random(100, 1000), faker.educator().course(), "", random(2, 8), random(2, 4));
                    newCours.setSpecialite(specialites.get(random(0, specialites.size() - 1)));
                    cours.add(newCours);
                }

                List<Presentation> presentations = new ArrayList<>();
                int minSize = Math.min(salles.size(), cours.size());
                    for (int k = 0; k <= random(5, 16) && k < minSize; k++) {
                        Presentation newPresentation = new Presentation();
                        newPresentation.setSalle(salles.get(k));
                        Cours cours1 = cours.get(k);
                        newPresentation.setCours(cours1);
                        presentations.add(newPresentation);

                        List<Presentation> coursPres = new ArrayList<>();
                        coursPres.add(newPresentation);
                        cours1.setPresentations(coursPres);
                }

                List<Seance> seances = new ArrayList<>();
                for (int y = 0; y <= random(presentations.size(), presentations.size()) + 12; y++) {
                    Seance seance = new Seance(random(2, 1000), random(2, 1000));
                    seance.setPresentation(presentations.get(random(0, (presentations.size() - 1))));
                    seances.add(seance);
                }

                villeRepository.saveAll(villes);
                etablissementRepository.saveAll(etablissements);
                salleRepository.saveAll(salles);
                specialiteRepository.saveAll(specialites);
                coursRepository.saveAll(cours);
                presentationRepository.saveAll(presentations);
                seanceRepository.saveAll(seances);

 */
            }
        };
    }


    public static int random(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
