(:*******************************************************:)
(:Test: op-add-dayTimeDuration-to-time-9                 :)
(:Written By: Carmelo Montanez                           :)
(:Date: July 1, 2005                                    :)
(:Purpose: Evaluates The "add-dayTimeDuration-to-time" function used :)
(:together with and "and" expression.                    :)
(: Uses the "fn:string" function to account for new EBV rules. :)
(:*******************************************************:)
 
fn:string((xs:time("10:10:10Z") + xs:dayTimeDuration("P02DT09H02M"))) and fn:string((xs:time("09:02:02Z") + xs:dayTimeDuration("P04DT04H04M")))