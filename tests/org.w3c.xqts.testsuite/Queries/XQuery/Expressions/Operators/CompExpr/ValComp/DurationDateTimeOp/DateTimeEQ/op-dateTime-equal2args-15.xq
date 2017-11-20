(:*******************************************************:)
(:Test: op-dateTime-equal2args-15                        :)
(:Written By: Carmelo Montanez                           :)
(:Date: June 3, 2005                                     :)
(:Purpose: Evaluates The "op:dateTime-equal" operator (le):)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:dateTime(lower bound)                       :)
(:$arg2 = xs:dateTime(upper bound)                       :)
(:*******************************************************:)

xs:dateTime("1970-01-01T00:00:00Z") le xs:dateTime("2030-12-31T23:59:59Z")