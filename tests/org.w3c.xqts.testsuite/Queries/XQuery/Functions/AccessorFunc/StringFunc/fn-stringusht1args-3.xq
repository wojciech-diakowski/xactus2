(:*******************************************************:)
(:Test: stringusht1args-3                                 :)
(:Written By: Carmelo Montanez                            :)
(:Date: Fri Dec 10 10:15:46 GMT-05:00 2004                :)
(:Purpose: Evaluates The "string" function               :)
(: with the arguments set as follows:                    :)
(:$arg = xs:unsignedShort(upper bound)                   :)
(:*******************************************************:)

fn:string(xs:unsignedShort("65535"))