package team4.Sacchon.representation;

import lombok.Data;
import lombok.NoArgsConstructor;
import team4.Sacchon.model.Patient;

import java.util.Date;
@Data
@NoArgsConstructor
public class PatientRepresentation {

    private int id;
    private String name;
    private String username;
    private String password;
    private Date lastLogin;
    private int doctorId;
    private String role;
    private String uri;

    public PatientRepresentation(Patient patient) {
        if (patient != null){
            id = patient.getId();
            name = patient.getName();
            username = patient.getUsername();
            password = patient.getPassword();
            lastLogin = patient.getLastLogin();
            if (patient.getDoctor() != null) {
                doctorId = patient.getDoctor().getId();
            }
            role = patient.getRole();
            uri = "http://localhost:9000/v1/patient/" + patient.getId();
        }
    }

    public Patient createPatient(){
        Patient patient = new Patient();
        patient.setName(name);
        patient.setUsername(username);
        patient.setPassword(password);
        patient.setRole(role);
        return patient;
    }
}
