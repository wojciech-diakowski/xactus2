(:*******************************************************:)
(:Test: op-add-dayTimeDuration-to-time-17                :)
(:Written By: Carmelo Montanez                           :)
(:Date: July 1, 2005                                     :)
(:Purpose: Evaluates The "add-dayTimeDuration-to-time" function :)
(:used as part of a boolean expression (and operator) and the "fn:false" function. :)
(: Uses the "fn:string" function to account for new EBV rules. :)
(:*******************************************************:)

fn:string(xs:time("12:07:08Z") + xs:dayTimeDuration("P12DT10H07M")) and fn:false()