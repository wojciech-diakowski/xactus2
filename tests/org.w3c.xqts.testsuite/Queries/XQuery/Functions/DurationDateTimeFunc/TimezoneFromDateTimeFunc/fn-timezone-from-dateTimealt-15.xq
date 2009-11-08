(:*******************************************************:)
(:Test: fn-timezone-from-dateTime-15                     :)
(:Written By: Carmelo Montanez                           :)
(:Date: June 27, 2005                                    :)
(:Purpose: Evaluates The "timezone-from-dateTime" function  :)
(:as part of an "and" expression.                        :) 
(: Uses the "fn:string" function to account for new EBV rules. :)
(:*******************************************************:)

fn:string(fn:timezone-from-dateTime(xs:dateTime("1970-01-01T10:00:00Z"))) and fn:string(fn:timezone-from-dateTime(xs:dateTime("1970-01-01T10:00:00Z")))
