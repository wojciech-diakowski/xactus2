(:*******************************************************:)
(:Test: sumdec2args-2                                     :)
(:Written By: Carmelo Montanez                            :)
(:Date: Fri Dec 10 10:15:47 GMT-05:00 2004                :)
(:Purpose: Evaluates The "sum" function                  :)
(: with the arguments set as follows:                    :)
(:$arg = xs:decimal(upper bound)                         :)
(:$zero = xs:decimal(lower bound)                        :)
(:*******************************************************:)

fn:sum((xs:decimal("999999999999999999"),xs:decimal("-999999999999999999")))