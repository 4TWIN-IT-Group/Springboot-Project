package tn.esprit.projectclass.services.Etudiant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projectclass.entity.Departement;
import tn.esprit.projectclass.entity.Etudiant;
import tn.esprit.projectclass.entity.Option;
import tn.esprit.projectclass.repository.EtudiantRepository;

import java.util.List;

@Service
public class ImpService implements IntService {
    @Autowired

    protected EtudiantRepository repo;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        try {
            return (List<Etudiant>) repo.findAll();
        } catch (Exception err) {
            System.out.println("Un erreur survenue : "+err);
        }
        return null;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        try {
            return repo.save(e);
        } catch (Exception err) {
            System.out.println("Un erreur survenue : " + err);
        }
        return e;
    }


    @Override
    public Etudiant addAndAssignEtudiant(Etudiant e, Option o, Departement d) {
        try{
            return repo.save(e);
        }catch (Exception err){
            System.out.println("Un erreur survenue : "+err);
        }
        e.setOption(o);
        e.setDepartment(d);
        return null;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e,Integer id) {
        try{
            Etudiant etudiant=repo.findById(id).get();
            try{
                return repo.save(etudiant);
            }catch(Exception err2){
                System.out.println("Un erreur survenue : "+err2);
            }
        } catch (Exception err1){
            System.out.println("Etudiant non trouvé : "+err1);

        }
        return e;
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        Etudiant e=repo.findById(idEtudiant).get();
        try {
            return e;
        } catch (Exception err) {
            System.out.println("Un erreur survenue : "+err);
        }
        return e;
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        repo.deleteById(idEtudiant);
    }

}
