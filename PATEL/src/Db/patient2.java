
package Db;


public class patient2 
{
    private int patientID;
    private String name;
    private int doctorID;
    private int age;
    private String address;
    private int phoneNO;
    


public patient2 (int xpatientID, String xname, int xdoctorID, int xage, String xaddress, int xphoneNO)
{
    this.patientID = xpatientID;
    this.name = xname;
    this.doctorID = xdoctorID;
    this.age = xage;
    this.address = xaddress;
    this.phoneNO = xphoneNO;  
}

public int getId()
        {
            return patientID;
        }

public String getName()
        {
            return name;
        }

public int getDocId()
        {
            return doctorID;
        }

public int getAge()
        {
            return age;
        }

public String getAddress()
        {
            return address;
        }

public int getPhoneNO()
        {
            return phoneNO;
        }
            
}
