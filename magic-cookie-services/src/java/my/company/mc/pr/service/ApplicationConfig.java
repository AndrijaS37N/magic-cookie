/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.company.mc.pr.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author andrijadjuric
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(my.company.mc.pr.NewCrossOriginResourceSharingFilter.class);
        resources.add(my.company.mc.pr.service.BakeryCityFacadeREST.class);
        resources.add(my.company.mc.pr.service.BakeryCountryFacadeREST.class);
        resources.add(my.company.mc.pr.service.BakeryFacadeREST.class);
        resources.add(my.company.mc.pr.service.ChocolateFacadeREST.class);
        resources.add(my.company.mc.pr.service.ChocolateTypeFacadeREST.class);
        resources.add(my.company.mc.pr.service.CookieFacadeREST.class);
        resources.add(my.company.mc.pr.service.CookieTypeFacadeREST.class);
        resources.add(my.company.mc.pr.service.ResponsibilityCategoryFacadeREST.class);
        resources.add(my.company.mc.pr.service.TreatFacadeREST.class);
        resources.add(my.company.mc.pr.service.UserAdminFacadeREST.class);
        resources.add(my.company.mc.pr.service.UserEmployeeFacadeREST.class);
        resources.add(my.company.mc.pr.service.UserFacadeREST.class);
        resources.add(my.company.mc.pr.service.WaffleFacadeREST.class);
        resources.add(my.company.mc.pr.service.WaffleTypeFacadeREST.class);
    }
    
}
