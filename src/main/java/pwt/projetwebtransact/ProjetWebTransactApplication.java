package pwt.projetwebtransact;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pwt.projetwebtransact.Entities.*;
import pwt.projetwebtransact.Services.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ProjetWebTransactApplication {
    // On déclare toutes les instances de services nécessaires à la création de notre base de données
    private final VilleService villeService;
    private final EtablissementService etablissementService;
    private final SalleService salleService;
    private final CoursService coursService;
    private final SpecialiteService specialiteService;
    private final PresentationService presentationService;
    private final SeanceService seanceService;
    private final CouponService couponService;
    private final PlaceService placeService;
    private static final Random random = new Random();

    // On crée le constructeur de notre classe principale, qui prend en paramètre toutes les instances de services
    // nécessaires à la création de notre base de données
    public ProjetWebTransactApplication(VilleService villeService, EtablissementService etablissementService,
                                        SalleService salleService, CoursService coursService,
                                        SpecialiteService specialiteService, PresentationService presentationService,
                                        SeanceService seanceService, CouponService couponService, PlaceService placeService) {
        this.villeService = villeService;
        this.etablissementService = etablissementService;
        this.salleService = salleService;
        this.coursService = coursService;
        this.specialiteService = specialiteService;
        this.presentationService = presentationService;
        this.seanceService = seanceService;
        this.couponService = couponService;
        this.placeService = placeService;
    }
    public static void main(String[] args) {
        SpringApplication.run(ProjetWebTransactApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
            // On utilise la librairie JavaFaker pour générer des données aléatoires
            Faker faker = new Faker();

            // Créer de nouvelles villes
            List<Ville> villes = new ArrayList<>();
            Ville ville1 = new Ville("Montréal");
            villes.add(ville1);

            Ville ville2 = new Ville("New-York");
            villes.add(ville2);

            Ville ville3 = new Ville("Toronto");
            villes.add(ville3);


            // Créer de nouveaux établissements et les ajouter aux villes
            List<Etablissement> etablissements = new ArrayList<>();
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

            // Créer de nouvelles salles et les ajouter aux établissements
            List<Salle> salles = new ArrayList<>();
            Salle s1 = new Salle(1, "Salle Murphy", e1);
            salles.add(s1);
            Salle s2 = new Salle(2, "Salle Marier", e1);
            salles.add(s2);
            List<Salle> e1Salles = new ArrayList<>();
            e1Salles.add(s1);
            e1Salles.add(s2);
            e1.setSalles(e1Salles);

            Salle s3 = new Salle(3, "Salle Boisvert", e2);
            salles.add(s3);
            Salle s4 = new Salle(4, "Salle Amine", e2);
            salles.add(s4);
            List<Salle> e2Salles = new ArrayList<>();
            e2Salles.add(s3);
            e2Salles.add(s4);
            e2.setSalles(e2Salles);

            // Créer de nouvelles spécialités
            List<Specialite> specialites = new ArrayList<>();
            Specialite sp1 = new Specialite(403, "Informatique");
            specialites.add(sp1);
            Specialite sp2 = new Specialite(420, "Science");
            specialites.add(sp2);
            Specialite sp3 = new Specialite(540, "Langue");
            specialites.add(sp3);
            Specialite sp4 = new Specialite(394, "Éducation");
            specialites.add(sp4);

            // Créer de nouveaux cours et les ajouter aux spécialités
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


            // Créer de nouvelles présentations et les ajouter aux cours
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

            // Créer de nouvelles séances et les ajouter aux présentations
            List<Seance> seances = new ArrayList<>();
            for (Presentation presentation : presentations) {
                Seance seance = new Seance(random(2, 1000), String.valueOf(LocalTime.of(random(0, 23), random(0, 59), random(0, 59))));
                seance.setPresentation(presentation);
                presentation.setSeance(seance);
                seances.add(seance);
            }

            // Créer de nouveaux coupons
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

            // Créer de nouvelles places
            List<Place> places = new ArrayList<>();
            for (Salle salle : salles) {
                Place newPlace = new Place();
                newPlace.setSalle(salle);
                List<Place> sallePlaces = new ArrayList<>();
                sallePlaces.add(newPlace);
                salle.setPlaces(sallePlaces);

                List<Coupon> placeCoupons = new ArrayList<>();
                for (Presentation presentation : salle.getPresentations()) {
                    placeCoupons.addAll(presentation.getCoupons());
                    for (Coupon coupon : presentation.getCoupons()) {
                        coupon.setPlace(newPlace);
                    }
                }
                newPlace.setCoupons(placeCoupons);
                places.add(newPlace);
            }


            // Ajouter les villes à la base de données
            villeService.saveAll(villes);

            // Ajouter les établissements à la base de données
            etablissementService.saveAll(etablissements);

            // Ajouter les salles à la base de données
            salleService.saveAll(salles);

            // Ajouter les spécialités à la base de données
            specialiteService.saveAll(specialites);

            // Ajouter les cours à la base de données
            coursService.saveAll(cours);

            // Ajouter les présentations à la base de données
            presentationService.saveAll(presentations);

            // Ajouter les séances à la base de données
            seanceService.saveAll(seances);

            // Ajouter les places à la base de données
            placeService.saveAll(places);

            // Ajouter les coupons à la base de données
            couponService.saveAll(coupons);
        };
    }


    public static int random(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
