(:*******************************************************:)
(: Test: op-logical-and-060.xq                           :)
(: Written By: Lalith Kumar                              :)
(: Date: Thu May 12 05:50:40 2005                        :)
(: Purpose: Logical 'and' using double values            :)
(:*******************************************************:)

   <return>
     { xs:double('-INF') and xs:double('NaN') }
   </return>
