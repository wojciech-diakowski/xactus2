(:*******************************************************:)
(:Test: sumlng3args-6                                     :)
(:Written By: Carmelo Montanez                            :)
(:Date: Fri Dec 10 10:15:47 GMT-05:00 2004                :)
(:Purpose: Evaluates The "sum" function                  :)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:long(lower bound)                           :)
(:$arg2 = xs:long(lower bound)                           :)
(:$zero = xs:long(upper bound)                           :)
(:*******************************************************:)

fn:sum((xs:long("-92233720368547758"),xs:long("-92233720368547758"),xs:long("92233720368547758")))