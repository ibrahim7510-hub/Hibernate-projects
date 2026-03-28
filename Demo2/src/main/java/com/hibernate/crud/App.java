package com.hibernate.crud;

import com.hibernate.crud.dto.OwnerDTO;
import com.hibernate.crud.service.OwnerService;
import com.hibernate.crud.service.impl.OwnerServiceImpl;
import com.hibernate.crud.util.InputUtil;

import java.util.List;
import java.util.Scanner;

public class App {
    private OwnerServiceImpl ownerService;
    public static void main(String[] args) {
        App app=new App();
        app.run();

    }
    public void run(){
        ownerService= new OwnerServiceImpl();
        try(Scanner sc=new Scanner(System.in)){
            do{
                InputUtil.menus();
                int option=InputUtil.getInput(sc);
                switch (option){
                    case 1:
                        ownerService.saveOwner(InputUtil.getOwner(sc));
                        System.out.println("Onwer saved successfully");
                        break;
                    case 2:
                        OwnerDTO ownerDTO=ownerService.findOwner(InputUtil.getOwnerId(sc));
                        System.out.println(ownerDTO);
                        break;
                    case 3:
                        int ownerId =InputUtil.getOwnerId(sc);
                        String petName = InputUtil.getPetName(sc);
                        ownerService.updatePetDetails(ownerId,petName);
                        System.out.println("Updated pet name successfully");
                        break;
                    case 4:
                        ownerId = InputUtil.getOwnerId(sc);
                        ownerService.deleteOwner((ownerId));
                        System.out.println("Deleted owner successfully");
                        break;
                    case 5:
                        List<OwnerDTO> ownerDTOList=ownerService.findAllOwners();
                        ownerDTOList.forEach(System.out::println);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
            }while(InputUtil.wantToContinue(sc));

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
