/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Db;

/**
 *
 * @author harlit
 */
public class phaPatient 

{
     private int patientID;
    private String name;
    private String dName;
    private String dieses;
    private int medicineID;
    

     
    

public phaPatient (int xpatientID, String xname, String xdname, String xdiese,  int xmedicineID)
{
    this.patientID = xpatientID;
    this.name = xname;
    this.dName = xdname;
    this.dieses = xdiese;
    this.medicineID = xmedicineID;
     
}

public int getId()
        {
            return patientID;
        }

public String getName()
        {
            return name;
        }

public String getDocName()
        {
            return dName;
        }

public String getDieses()
        {
            return dieses;
        }

public int getRestriction()
        {
            return medicineID;
        }

}
