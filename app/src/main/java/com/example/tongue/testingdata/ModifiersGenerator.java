package com.example.tongue.testingdata;

import com.example.tongue.models.GroupModifier;
import com.example.tongue.models.Modifier;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ModifiersGenerator {

    public static List<List<Modifier>> getModifierListsFromGroups(){
        List<GroupModifier> groupModifiers = getGroupModifiers();
        List<List<Modifier>> modLists = new ArrayList<>();
        int opcion=1;
        for (GroupModifier groupModifier: groupModifiers) {
            List<Modifier> modifiers = getModifiersFromGroup(groupModifier,opcion);
            modLists.add(modifiers);
            opcion++;
        }
        return modLists;
    }

    private static List<Modifier> getModifiersFromGroup(GroupModifier groupModifier,int opcion){
        String[] modifierNames1 = {"pizza hawaiana","pizza siciliana"};
        String[] modifierNames2 = {"queso","peperoni","carne picada","aceitunas","jamon"};
        String[] modifierNames3 = {"queso","peperoni","carne picada","aceitunas","jamon"};
        List<Modifier> modifiers = new ArrayList<>();
        if (opcion==1){
            for (int i = 0; i < modifierNames1.length; i++) {
                Modifier modifier = new Modifier();
                modifier.setName(modifierNames1[i]);
                modifier.setGroupModifier(groupModifier);
                BigDecimal price = BigDecimal.valueOf(i + 1.25);
                modifier.setPrice(price);
                modifiers.add(modifier);
            }
        }
        if (opcion==2){
            for (int i = 0; i < modifierNames2.length; i++) {
                Modifier modifier = new Modifier();
                modifier.setName(modifierNames2[i]);
                modifier.setGroupModifier(groupModifier);
                BigDecimal price = BigDecimal.valueOf(i + 1.25);
                modifier.setPrice(price);
                modifiers.add(modifier);
            }
        }
        if (opcion==3){
            for (int i = 0; i < modifierNames3.length; i++) {
                Modifier modifier = new Modifier();
                modifier.setName(modifierNames3[i]);
                modifier.setGroupModifier(groupModifier);
                BigDecimal price = BigDecimal.valueOf(i + 1.25);
                modifier.setPrice(price);
                modifiers.add(modifier);
            }
        }
        return modifiers;

    }

    private static List<GroupModifier> getGroupModifiers(){
        GroupModifier groupModifier1 = new GroupModifier();
        groupModifier1.setContext("Elija el tema de su pizza");
        groupModifier1.setMaximumActiveModifiers(1);
        groupModifier1.setMinimumActiveModifiers(1);
        groupModifier1.setType("mandatory");
        GroupModifier groupModifier2 = new GroupModifier();
        groupModifier2.setContext("Elija hasta dos ingredientes");
        groupModifier2.setMaximumActiveModifiers(2);
        groupModifier2.setMinimumActiveModifiers(1);
        groupModifier2.setType("mandatory");
        GroupModifier groupModifier3 = new GroupModifier();
        groupModifier3.setContext("Recargue su pizza con hasta tres ingredientes extra");
        groupModifier3.setMinimumActiveModifiers(0); //If optional then zero is default
        groupModifier3.setMaximumActiveModifiers(3);
        groupModifier3.setType("optional");
        List<GroupModifier> modifiers = new ArrayList<>();
        modifiers.add(groupModifier1);
        modifiers.add(groupModifier2);
        modifiers.add(groupModifier3);
        return modifiers;
    }
}
