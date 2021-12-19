package com.usa.ciclo4.reto3ciclo4.repository;

import com.usa.ciclo4.reto3ciclo4.model.User;
import com.usa.ciclo4.reto3ciclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
/**
 * Class UserRepository
 */
public class UserRepository {
    /**
     * instancia UserCrudRepository
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Método que retorna la lista de usuarios
     * @return 
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     * Método que retorna el usuario por id
     * @param id
     * @return 
     */
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    /**
     * Método que se encarga de almacenar usuarios
     * @param user
     * @return 
     */
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    /**
     * Metodo que actualiza usuarios
     * @param user 
     */
    public void update(User user){
        userCrudRepository.save(user);
    }

    /**
     * Método que elimina usuarios
     * @param user
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /**
     * Método que verifica si un email ya existe
     * @param email
     * @return
     */
    public boolean emailExists(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }

    /**
     * Método que autentica por email y password
     * @param email
     * @param password
     * @return
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Método que se encarga de retornar el usuario por fecha de cumpleaños
     * @param month
     * @return
     */
    public List<User> getByMonthBirthDay(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}
