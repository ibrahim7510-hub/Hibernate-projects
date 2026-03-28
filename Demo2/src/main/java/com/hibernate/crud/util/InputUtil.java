package com.hibernate.crud.util;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.enums.Gender;
import com.hibernate.crud.enums.PetType;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class InputUtil {
    public static void menus(){
        System.out.println("Welcome to pet shop");
        System.out.println("1.save Owner");
        System.out.println("2.find Owner");
        System.out.println("3.update pet details");
        System.out.println("4.delete Owner");
        System.out.println("5.find all Owner");
    }
    public static int getInput(Scanner sc){
        int option=sc.nextInt();
        if(option==1||option==2||option==3||option==4||option==5){
            return option;
        }
        else{
            return getInput(sc);
        }
    }
    public static boolean wantToContinue(Scanner sc){
        System.out.println("Y to continue N to exit");
        char option=sc.next().toUpperCase().charAt(0);
        return option=='Y';

    }
    public static OwnerDTO getOwner(Scanner sc){
        OwnerDTO ownerDTO=new OwnerDTO();
        System.out.println("Enter ownerId");
        int ownerId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter First Name:");
        String firstName=sc.next();
        System.out.println("Enter Last Name:");
        String lastName=sc.next();
        System.out.println("Enter the Gender:"+ Arrays.asList(Gender.values()));
        String gender=sc.next().toUpperCase();
        System.out.println("Enter city:");
        String city=sc.next();
        System.out.println("Enter state:");
        String state=sc.next();
        System.out.println("Enter mobile number:");
        String mobileNumber=sc.next();
        System.out.println("Enter emailId:");
        String emailId=sc.next();
        System.out.println("Enter petId:");
        int petId=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter petName:");
        String petName=sc.next();
        System.out.println("Enter pet BirthDate:");
        String petBirthDate=sc.next();
        System.out.println("Enter pet gender:"+Arrays.asList(Gender.values()));
        String petGender=sc.next().toUpperCase();
        System.out.println("Enter pet type:"+Arrays.asList(PetType.values()));
        String petType=sc.next().toUpperCase();

        try{
            ownerDTO.setId(ownerId);
            ownerDTO.setFirstName(firstName);
            ownerDTO.setLastName(lastName);
            ownerDTO.setGender(Gender.valueOf(gender));
            ownerDTO.setCity(city);
            ownerDTO.setState(state);
            ownerDTO.setMobileNumber(mobileNumber);
            ownerDTO.setEmailId(emailId);
            ownerDTO.setPetId(petId);
            ownerDTO.setPetName(petName);
            ownerDTO.setPetBirthDate(convertDate(petBirthDate));
            ownerDTO.setPetGender(Gender.valueOf(petGender));
            ownerDTO.setPetType(PetType.valueOf(petType));
            return ownerDTO;
        }catch(Exception e){
            System.out.println("enter valid details");
            return getOwner(sc);
        }


    }
    public static LocalDate convertDate(String petDateOfBirth){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(petDateOfBirth, format);
    }

    public static int getOwnerId(Scanner sc) {
        int ownerId = sc.nextInt();
        if(ownerId<1){
            return getOwnerId(sc);

        }else {
            return ownerId;
        }
    }

    public static String getPetName(Scanner sc) {
        System.out.println("Enter pet Name");
        sc.nextLine();
        return sc.nextLine();

    }
}