package com.repository;

import com.domain.Entity;
import com.domain.Paciente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Repository<Entidade extends Entity> {

    private EntityManager entityManager;
    protected Map<Long, Entidade> repositorio;
    private Class<Entidade> type;

    public Repository(Class<Entidade> tipo) {
        type = tipo;
        entityManager = HibernateUtil.createEntityManager();
        repositorio = new HashMap<Long, Entidade>();
    }

    public Repository<Entidade> merge(Entidade entidade) {

        if(entidade instanceof Paciente){
            Paciente p = (Paciente) entidade;
            System.out.println(p.getCirurgias());
            
        }
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(entidade);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.merge(entidade);
            entityManager.getTransaction().commit();

        }
        repositorio.put(entidade.getId(), entidade);

        return this;
    }

    public Repository<Entidade> remove(Entidade entidade) {

        entityManager.getTransaction().begin();
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();

        repositorio.remove(entidade.getId());

        return this;
    }

    public Repository<Entidade> remove(Long id) {

        repositorio.remove(id);

        return this;
    }

    public List<Entidade> search(Long id) {

//                CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//                CriteriaQuery<Entidade> cq = cb.createQuery(type);
//                Root<Entidade> root = cq.from(type);
//                Metamodel m = entityManager.getMetamodel();
//                EntityType<Entity> Entidade_ = m.entity(Entity.class);
//                
//                cq.where(cb.equal(root.get(Entidade_.)));
        List<Long> combinacoesId = getCombinacoesPossiveisDadoId(id);
        List<Entidade> resultado = new ArrayList<Entidade>();
        for (Long combinacao : combinacoesId) {
            Entidade e = repositorio.get(combinacao);
            if (e != null) {
                resultado.add(e);
            }
        }

        //return criteria.list();
        //return resultado;
        return null;
    }

    private List<Long> getCombinacoesPossiveisDadoId(Long id) {

        String idAsString = id.toString();

        List<Long> combinacoes = new ArrayList<Long>();

        for (int i = 0; i < idAsString.length(); i++) {
            for (int j = 0; j < idAsString.length(); j++) {
                if (j <= i) {
                    combinacoes.add(Long.parseLong(idAsString.substring(j, i)));
                }
            }
        }

        return combinacoes;
    }

    public Collection<Entidade> getAll() {
        //return repositorio.values();

        String query = "select * from %s";
        TypedQuery<Entidade> nativeQuery
                = (TypedQuery<Entidade>) entityManager.createNativeQuery(String.format(query, type.getSimpleName()), type);

        return nativeQuery.getResultList();
    }

    public boolean exists(Entidade entidade) {

        if (entidade == null || entidade.getId() == null) {
            return false;
        }
        String query = "select * from %s where id = :id";
        TypedQuery<Entidade> nativeQuery
                = (TypedQuery<Entidade>) entityManager.createNativeQuery(String.format(query, type.getSimpleName()), type);
        nativeQuery.setParameter("id", entidade.getId());
        return nativeQuery.getSingleResult() != null;
    }
}
