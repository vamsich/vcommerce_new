package com.promotionmanager;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.promotionmanager.order.promotions.OrderLevelPromotion;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
 
            OrderLevelPromotion orderLevel= new OrderLevelPromotion();
            orderLevel.setTotalAmount(Double.valueOf(1100.00));
            kSession.insert(orderLevel);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
