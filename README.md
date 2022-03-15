# Online Shop

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Web project based on hexagonal architecture and DDD using Spring Boot and Gradle, for the development of an Online Store implementing the PayU payment platform.

An integration is carried out with the PayU payment platform in which the payment creation and payment refund operations are implemented.

The CQRS pattern is implemented to separate read and update operations, maximizing application performance, scalability and security;

The event sourcing pattern for the traceability of business operations.

And the saga pattern with choreography for communication between the different microservices, each service or microservice will communicate with others through events to decide the next action to perform (Event-Driven Architecture).

PayU documentation: http://developers.payulatam.com/latam/en/docs/integrations


## Businnes 

### C4 Model

The C4 model was implemented to visualize the architecture of the project

#### Context Diagram

![_C4 Diagram - Shop Online-System Context Diagram drawio](https://user-images.githubusercontent.com/23733231/158483457-be152422-13e3-43c1-941e-6e0d52716e76.png)

#### Components Diagram

https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&page-id=xuUuMmyP9B9rYQ6Ts3kP&title=%20C4%20Diagram%20-%20Shop%20Online#R%3Cmxfile%20pages%3D%225%22%3E%3Cdiagram%20id%3D%22B4Z9xZYi-bppS7oQ2Bng%22%20name%3D%22System%20Context%20Diagram%22%3E7Vptc9o4EP41fEzGL9jAx2KS9GbapjdcX9JvwhZYjW1xkgjQX38rWcKWMRRIJmGuZJKJtZZW0mr3eXYFHT%2FKV3cMzdOPNMFZx3OSVccfdTzPCzyvI3%2BdZF1K3NAdlJIZI4mWVYIx%2BYW10NHSBUkwtzoKSjNB5rYwpkWBY2HJEGN0aXeb0syedY5meEswjlG2Lf1GEpGW0r7Xq%2BTvMZmlZmY31PvLkemsd8JTlNBlTeTfdPyIUSrKp3wV4Uxaz9ilHHe74%2B1mYQwX4pABMRr%2FwA%2F3cZQPfzx%2BQS4Xt9GVq9VwsTY7xgkYQDcpEymd0QJlN5V0yOiiSLBU60Cr6vOB0jkIXRD%2BxEKs9WmihaAgSkWe6bd4RcT32vODVHUd6NZopTWrxrrW%2BIwZybHAzMgKwdbf642aJtmsVKnWut5qKksQT9Wm5Kq2jWsMRRcsxvssqp0UsRkWe%2Fr5ZT9p7doE%2BujuMIWlsTV0YDhDgjzZ7oi0V882%2FaqDhwd99u1%2B8DUk8ft7H30K7%2FvO%2BNvN38HTxKz6CWULPdMYF4lcX45IxuFhwUkxa3WWD2gCUW8dMMrIrIDnGMwnDTx8wkwQiKp3%2BkVOkqT0JczJLzRR%2BuQpzCkphNpdMOwEo9aj2OvJcia8asMGPYsVfpap9agr59obDIJyrMYtc1wHn4bW%2Fllup1JtFmm0ur6tgU6nHLymeZqbNR50wO3m8bZO%2BCN6xMqy6xyrRT4RJBEXCbxE67fEhQoLHmpvTsGFCgoeLCQ4X1wI3goX2lcd7AKGBAkkdcuVxFguxAsz2NhwwuBpJpSxQpTDyQ%2BLCZf%2FSDGlDHiR0OJNveuZrGM5BLD6XE6XkeLxVfzDPZQ4DMaY%2FONU6HoONtHJT5mUgUUyFOMUki%2FMGnlb9xPK9ZruC7CihKRxCkeqX%2F%2BznhvHo1OxBMvKDmsucG66jDCPGZkrv1I9oxQB4mcq3wNvdKhRPIdDSBHHktDoVPk1I3Qhm3NGk0UM1KOUZiWnjVSr9OspVeaofDb8d0HNiyuuvO4ddHDD%2Bap6WYuFMjoqQaD37gXmJVhv0hwAsnJmW5yQp40oKJUpS4GyYFQbW%2B%2FXFqBbyo7drbtvt1pLTDPKLC0dz4%2FVT9vYwD5Syz5ttmhu0%2FstqtXcXKNgDYoqoJEBvkyJwOM5UsG7hCrHBhXlKEMUP87UsEjvtKCFxKwpybJos3nfdUJ36Gi71ORT9dOWNyEWazxz5TguGH3EtZHOKHAGch0Qg%2BgmIUIva39aNYQMB4waOepP%2BkukhG2y3rbQlS2jwRa2yXpBm0q3Ze6mzGsRtqpsmdtpLHJHLrkra9ydHQ58x07iwkALllWB6HW1LK0XhwaKj6BpaGoQPYK1B%2BeTvG0Y9ZTkTWbhVmEXBuEbpnD%2BgRTdPa8UzvltbQdH%2BQaFHaMCac52Dq%2FzBi9Y5jm9%2FouUdVeDBiT0n1%2FWHZc63VzJs9zKjE5Jnj6WijhmYONNCsXBZdQFwG2Z7qtnp6CCTOH45ehL5vQHZE7%2BG2VO%2FajfHYQvmTn1%2FLDX9y6Z0ytmTkH%2F7DOnfgtXYqs6jGRUppRyKRapBFIHKTrN9X1avcbUhee5ZGPHX6W9UOrUPfR245VSp%2BPYFYzCJZw68YIL0M22%2BdV02UGq74r6NQQoUUxcqZNeBTCsakQJnQTCATZU67sAQr6%2BUOz%2Fn2K7eym2FuJyNkNxbj1UHUO%2B3CbfBqc6ff%2B2F7TeKoS%2BG0R72Nbceuarmfzc9zruXs9VAHhtVNxg2C1G3cWTZ0GJZanSSApe5B7BbbDhRlBnQ6eNDfvPZsMj8Q%2BtvzynpLACprx4xSvwDSA0RR4bPVzpucDcHwBzwaWSuFQSJ2Nn8w62679eJXEcdt5ROsvwc9DzL%2FBDoFmNnuV1TEZjVIfTCUNFnOKyPtmkkXKbibqhK7%2B8IbNMKBVSsDwx4yMVeNDgIOObYoYUiexCGb%2Bg8R%2BAxu7lYucCxyfDses1L8DP72bH7W1d7Rwd2f2DcMzAuRPBcMhz4WlEECB4fhSqNe6MlCYrzpoOLS%2BBuI6MtsDZ%2BVHN9kcz9SDVcWvHmRba11RlF%2FM12b0XRkc4V6%2FJ9Rtnq%2FuW3%2BJbp7lW9Y3c8kOa6ovN%2Fs1%2F%3C%2Fdiagram%3E%3Cdiagram%20id%3D%22xuUuMmyP9B9rYQ6Ts3kP%22%20name%3D%22Container%20Diagram%22%3E7V3Zlps4E36avrSP2OGyvSXzZ5lknEyWmz4YsE2axQM43c7T%2FxIgDELGYLO5G2cysQXIBn2qqq9KVbrjpvbzG0%2FdbT%2B4umHdsUB%2FvuNmdyzLiIoA%2F0EtB9zCKFHLxjP1uO3YsDT%2FGHEjiFv3pm74mRMD17UCc5dt1FzHMbQg06Z6nvuUPW3tWtlv3akbI9ew1FQr3%2FrN1INt1Cqz0rH9rWFutvib4S1HR2wVnxzfib9Vdfcp1cTN77ip57pB9M5%2BnhoWenr4uYx%2BPP%2BtbDdf9OVbfbo1p2%2F%2B9%2FHNKOpsUeWS5BY8wwku7vqtKP9wvz89%2FuR2%2By%2F%2F%2FWR0YPwZKVzU92%2FV2scPLL7Z4ICf4NPWDIzlTtXQ5ycIkztusg1sC35i4FvP3Tu6gb4EwE%2FJQ0KHNpbq%2B%2FEBS10Z1kTVHjfhBVPXcj14yHEdA132aATaNj517TpBDCRGRgcDz31MRk9CZ5iWhXu4Y7m1gP4kZ6aOiOEr7jPVHr1ge8lHGw%2FBb8MLjOcUsOJH%2FcZwbSPwDvCU%2BOhIwBMgnjgjWYwbno4wZAUpbtymMSiDuFWNwb9J%2Bj8OMHwTjzF9vP0n8eHHj4%2BOAfaBKH927dXDKLmPy4d746m6aRwfZjyA6RGJm47AQNfpqr9NPuTGCQBFASA31nKDI5TM62SAmPwAMZJMGyCJqWGAqBNSYmuckEx6QoL6JiQxmUD4og9r5ggeVoYOmBPQyiCnKTRI5HSVBGks5PAgAQocWJCceg0eFsrzfD9%2F%2F5X3rd3Uefyq%2FZ75%2BEZSo2%2FoUL%2FFH10v2Lob11Gt%2BbGVkMjHc9677i5%2BjL%2BMIDjEQ6ruAzeLIOPZDL6jy8dC%2FOlH3Bl6P3tOfzikPnwyPBPetuHhNgc%2BgqgjRRFwQ9jXWBRE3HDsMPx0SH8iu7wCDL679zSj4FnHujBQvY0RFJwXjzUaiEJoeYalBubvrCFSO0LyAmNpODr6fbZqWj4VP%2B%2FR3M%2BOuWqZGwe%2B1%2BCzRE97guaOCe2o%2B%2FiAbep6BC%2FDN%2F%2Boq7A%2FNCQ713SC8K6EyZ0wCwEYwBt3nfiE%2FDAVQT03ZxPbMP7OjPlF1b1gDCQ5urT0GMS9fUI3k%2BpKIZVEtgd3vfYhVsgxTH7T5ZoaUAeu6YmPJywzBoDJTlheuWS%2B%2BnA2BffIjkfYQurH1HDzwrSOX6zjk2KpD1vi4x1M%2B0JbufF5765%2BISYEb9GCOn4LGY%2FhEWSJ%2F6jacf%2FzEZrnsHF58APDxid8OeywOHDXwRN8WLlTZoaveeYunqmwNd3AAneNbvYZjiWEUPggk378sJ9x1JEVCZPIVBGtIDYQMuAV%2F9u7%2BMDID%2BF3D09gxN3z8SB8t4n%2FDXtZHRuE%2BI5ZAR%2BEz2xFXgDbom%2FONuvm76RJiDoLnw7sTJilrk2fh3%2BCV9RZ1btliu427kVLrKfjiZwWvmjXCtlhzDwf2rMgb5M9p164FMZjuZWSSVlb84xhWmxxEpxOnsq8QmFu6%2FBFU1iqp2EjlWqMSpwoyfBeJnD%2BqXPdDLC9XKjPJmCMHuoUhH8RXqZhI61Nyjcy6BPuIdtIa5MEWpcM5bvJNpbSSO2S8t2A%2BJGhEm%2BMdzEioVMZhcKMeRrvYqvTLvgxlqcVbCq%2BP1Y3PlLe6m5SVwqd6Uq6fSbJImGfCQREop8aX1bFTKumheEg%2BKHW1PZ%2BAHv18noYn1Je%2Be7CKwY1%2BwrUrFCoZlNSIu2LyfjVAFbAflYBE3oVyNxCovpKgcgxwrRA4%2FpbNcSy%2FbxBwYKxxo8jhLI0dUxo2ZxWPaUre6EWIxpLGAZNaURREgiFCGSKRqS5nhj5ao1YUc6ph68DxRhkX52yTxwoxkAx6hSoEpdlGAxg22MY1eTpG9fdQFgMEnWQqDVKVGmQqINErVOijpIlCdhG5bi%2BOW3i0Ewmcp6d63hxEp6RTKEYOy8beECTDVN4kmo6yAUAZqYKuZJdSf4Rnic4QkF2SpLYR66k%2BN6qRfLykTtKVD47JXNrO%2BjR%2FaZwyCQLZhLVTsEhR1tVw1WHYcklG53G6PH7KEiHPYcnvIXHeHw2Gn93SWQvvbAk43Msv1wkFRtM0HYMDEZfreejh8fY4HUuTupwynLex3mattTu4oR3qx5SJ8Rz9KQHlOEJY5cVuDSkz1%2BgAFB8AcNfewFffEHitKWfD99ET6URz%2B03A8n6%2B93OgjIyssdIYzwl0eNDhrZ1IKI38Q82xpsxstR3nulsJmhFKFTRLJhDxELJuzSglbONmoxAG1cx5bWUMvFcxBQWUPzvXMc3V6ZlBocXYM%2BHvyJqOT7X27Hz5yL604mdz6QXwlxp6JOO5UqGP8vdszOlTsMfzKXZ%2FWww%2FEsa%2Fhlt3BgL4MlVkgJojwVUE%2BsfXCgfjUiyDxJ9kOi3ItGZQaIPEr1Dic5I7Un0kkvguS75NSbRpfg1ZTXO9TT5FGtP1udWYe2Xk2X62FAWBBVYqnWy5evSKrpd4XUlpnrmx%2BkMU0xXmKI6jjDEO1qyDzJIOAKjfz69FvBCHSC2JbhUIyr3OxO2vFED40k9DExlYCq3wlSKlywOTGVgKrUyFTITr38BaCaOCBXlblPjWSeS5M4XWaiupuM0%2B7pyDWq1Pmq2C6S6zcgU0AQKznDbtSmnrEA6WUkAR7eey2mgdEWu2kjC52fSI6pGIUeiTPoRmKtieCVnnNT%2FGZdj8TXMlLoS9LuacWWdAcOMqzDj%2BOui5uVIrnx9BZmhPkkd9UkEjgntMMICohcoYdg6CpRQASEIeYl7O560mh0elxc4uFwS031ReUlMPY%2FnS0riZhcxSWRKMB9D%2B5ScJS%2FghbvGRZ%2FYaRyi0jq%2FYp8xYNgabJDXPnW4llKcGUaSxjI4vlj6VGkn4%2FnomPzL%2BQ0fuBve4oclPn50V1byXn4wNQ9Oi31wmafSRpf7hvfb1NCSjyB07vXNf4ldjtf5L3Ndxw7N1JOOvJqiaiPDy1n5u%2BQXnHZx0n5K4dd25Qe9wr9Zxu1JeyDsOc1QvGYDp01vjWd1g0A8iRfrC6EPMSVW4zMSSYvE9DnPqfls4KqreeO6kh91IU%2FnU5z%2Fjbukpnbn7OiJLPDh3Vya9H2527NuZybp4z3JTzIMhKQGyDV%2FL05opUcvDJuWpwoyINLJBUphS3o2OclVa%2FCU0knDK1%2FS0U%2FLp2whtL6SBhb0jzTIdRZYHvwll%2FtLONB2PVc6iex04dG1JPK1Sz6pGclH4XwypOmpF6HRsaRrm%2FN98lx9H55ehvGBgfQNpO%2FFkr7iwpg3Q%2FoWC%2FZC0jeD%2FCYs4j2QvtTjnCndkD7S3mFpRTU7JX1yieUxgyncgilMKS53ImzYVMkEQRr4f%2F%2BsYP62%2BX8fQ4adBscHtncdznFZzhYifEwWyfxYSb0kiauJ7ZXcFAy8QkWtG2t1H%2FKAPulqjpKNWZuursb9%2F%2Fb0kFQPzH9g%2Fq%2Bb%2BfMvgvnPBYYHpGQtGe5lY5H6Wpn%2FqUyjE6qjNdJP22Ky20CvMhC9%2FhnAZRNm6yd618XOOvUaDGzqOjDhHfmaZ1NiUeyMF7sJnS235s42nCF2NljQgwVdnDp%2BKxa0eA%2FAYkGxoEsnoucsa8j3QRiOe62WdVumMld6h53WwmO0%2BuUv3evWw%2FAYw5fOqmtskVg3lYQG1lRo6Io3yprEgTXdLpgkqS3WRNRXSUqptL3EUD0gmuQPPGngSa%2BeJxXvjHcrPAkAAczr5UkAMLPJwJOa50lM70IKfCf2TN8rY9KNhxu1WJkuRnigP8VgYm98eeBIzK7468cCwbyPZyBntwN1rrWYllKYD4ah3TZZ%2B%2BqXXhI2sLSBpb1Qlsa%2BjAVhumDIOk%2BhaefpmMxOOHFIBcvoOEWaAUlqkqqRWkCiVUTulKtxJaofJHZDaMzsAwtKMSjNnPCrwsYU3HNQDBH%2ByfXNWEHkNr19T5ywcoPAte%2Fyu%2BIGyHia4MlqP8Mh3W3HT8YKCkzXH9uus3H1Vc786jjKFtdzLo6yRXmeizBW3fISRYYR%2BbFEAFUAyhgIKXNGyuFWpMFWlMdNcU6uRPRV9XcRKEOhmwVmfivlHFRNW90YFPEat89MewN%2FumVC1bNQ%2F%2Bw9A92SrgbqSvUNH%2FEP1Pgwi1seIKiDjWcsP79%2FWELbx%2FDG%2Fu9NY%2Fh8MXgk9qYdSYycQx8DASpQAIh9T7XDD3PmIvghwZh7tHxocnkQl5F4g9wGtWegmbIwVnC8V%2FAJp5gcBbpUKdyd2OsJdJJFAEX6lqHJLUGorm9zuNlYrKwo3ufP2y%2Ff%2F53sPkjG%2BueIlW%2FFf5CHLb0ienZXMyU51tTWAXTHKZt3AFCfP9NWeFYgS5SLAtFJw0mBbIns%2FczsblFb2r6mIno%2Fc7XHqmqwId0GLd%2F2dRvHkiDBeyeeKaTPN2VWSSX02mBWvQSzKleMT%2BqBWYWJxwC%2FFw%2B%2FPMvk%2BwDAEhvUDAB8CQAkSjgw2ITsFH2DU%2BN1oo9T2kUfnZveTLpmnpvWzCfxrknN08RTG6m0RRNldqCJN0cTOTlvKjVFE%2BmiotMyAZWWwZRwWgl8Sa9V83KHUti4JT%2FWVYaLXMJtMEiRnkkRRmzP2UQFMXbH35IUGfOykpYkYKwIbEaa9EaWUFKWbkKWlKDggyzpWJYQWQcCT9mroV1Z0uka9LotEqVsHK15KSLfqBRRBilya1KElZTOxUgeJTcsRhiW7YscwdnKtyZHFAzrQY7cjBwRQPfmyAvZezhDdTKyReR6I1rYvomWakk59ztV26IEmHfq%2BlHFxy8voUD2dzZDZ442Bp7s%2FeiEztJrzqXS1JM5Q8uS8VpOigFaIjWPJ3JzEf2hXXtB8kzmDtizWo5NTYTTGTHawTKhhPKQkI9zYhjhjr6g9UwezCqSde9X%2BVpY5%2BOChOJhuXt2plCU5hX1CubS7B4p6BecIMMQJkEmITRj03huoMbDq1RfvVlBk0sS6aOk1NNPKt1kwqJs9SW7F6XI4B%2FUZ4Pw3X5leA7UwX6d0fgXFIAXmGz8fUTZfItqL8oN0QzxBtwVA6qqoooVS9KQ6rAqY2J%2BVO0YOu9dVYdNEAeqo6WyuxMbtGzi93Lnmc5m4rpx5vccjnNgaktD9SA0L0oG71nad%2FjQrk77FrJGbvgrBsv0Asu02DDNZk%2BfS71OybrKydYZG7OUTQlnBP42ujw7YWKS9lrO5GTzNifNDk0sxjqNU4lindIs1ugr6jRjuy2zxYqEaOdoudsNGabVZP0%2Fxsb0ox%2BvOkjqz0xfc%2BGtHgaxP4j9GxH70iD2B7HfQ7HfP39ENwnFx%2FVQwt3JEEHZAEFbVcmqoeR81bG7XNihqKpjXwKaN7BUc%2FA0nHOUikT1b44FlJAny0pjIOeFE8vU4Md69xVYP2x3JY6%2B6erXb2%2F%2FrPebEVOigFDX6FpGheceJnsMr8aGic%2FVtJTkJO%2FxjFOojhoU9DG6AQnQ5RjxQjlncHMDdAOlG7ocIJbCvdsdoBJ5mq9ogES8ZDuxkjm%2BcymHDahhjKiTiMX1YTobH3YYn4Lx4SnVENodn0HGZVYmkPWcGK7rCXQDIeMuJlAL41G4urBwPDKEkqWTz5iWZuqs5kaD7uCU7%2FIVUQ1zN7YN34ejNN2qjoO86a2t6JEUMGYzE4djxzjnPF3sQBClMS6un6GqTQ0XP%2BifjA2Ha%2Bgf5Vt7Btw3e7WwPtu%2FPGdns%2FvHhf3wThvR1lllIx%2FRUzzGJ5jCYM%2F5SAkn0CIlfzthIU8WLLfurlJ8iEATHIogCxvS548crXhdJQ1DZAlk29T10KGbxx9l086sqIkbCc9azuHVFOBGHFH%2BSaBtXMRSAMfVADjHYd4qf9aiM%2Fp7uf3yR3wTCF%2BpgCMFQixb8WQ%2BW7T6hEdSN9bqPgQNvap1TtaEX3iPW0FKbmyDYOeH%2BF3A%2F%2FY7y1X18ZP5aNqGbqpj10NiBX3eoc%2FwvebatuugUj7Bdm8jcaOhv2v4v3tns7dU72G9t6yHMCT4gIpph7KHXbCAl3fPo4KTxjunSSE1yhWt4xWJ4vZkGIlaOefYXDt2ypDNfmIngU5gaNtx4Jkr1ToExtjYI9zsRihOj8YRY8sPkYA8IAtUz34Bf7SptT7wtDgcQ5MWl8ThckN%2B2DILZ%2F199Onthzf%2F%2FBJ%2BLt7pdkeBt%2BuKFyiMeMfVULwgZcSgZQ6Z0MoRn2V2UEvtFHQM3B03CyJjLhlVVk9OEXVw4%2Bnbn5SicpgsYdO%2BuC3Jj3jr067kAmVF%2BYldyZsSUDedgvgCtiqjDgplpzLqeULdciW%2BNLdRmVi0UZkoN1aNjpeA8%2FbfJ%2Bu%2F9V%2FCp92njfW%2FhYBN8HYhWwSoE8rscjgVy7LrJdYlAOx2j9FqybJvVQdSXi9MWb0bthy%2FPNv2kuWtw2Z2Fy9%2FrWMzu9Pz%2BWzmbt%2F3sptzUxmQ1uJ1KbwToAhhly84hbeTRbHkluMioHju2trGrsh4Gspov7Iy2iJDiSw1WEabCr4bWLw1FAzKSjCJbbNgEBU1QzC%2FaDWMSHH3NhWM%2FMOJM8n59uPn9Nc%2Fm8VXeyMv6cHIouEhjQxKms7V%2BTw5u6FMMg41a4eS3sOcMGHYsiaMRLOULjCpTm9wSEgk%2BGeBRpS6ty8vzBZs6tgsVbHGQT6DvHQS7jkwEWgSLjFCM0s0LtzAtuTKjsQYxs4QqhAg136oTz4%2FhtZj6BT4SwsJAPwYvcueZasOnPr6A7xbQ7VNZ%2FOwdr2Hx7CEVDXTvjGpIHNZqTCSG5MKiK6jbNeUdws9qg%2Bujtj6%2FP8%3D%3C%2Fdiagram%3E%3Cdiagram%20id%3D%22WJB-mFxG06Mu8UMHiH9Y%22%20name%3D%22Component%20Diagram%22%3E7Vlbc5s6EP41foyHiyHuY4zttGfSTtp02uYpI4MMSgSiQnbs%2FPqzEou5mObUmdM2M8WTC%2FtptZJWu59WZuQG6e5Skjx5LyLKR44V7UbufOQ4U38KfzWwL4GJZ5VALFlUQnYN3LAnimCltmERLVqKSgiuWN4GQ5FlNFQtjEgpHttqa8Hbo%2BYkpkfATUj4MfqVRSrBZTnnNf6WsjipRrb9N2VLSiplXEmRkEg8NiB3MXIDKYQqn9JdQLn2XeWXO%2Ffq8vP9u3T2wf5y%2Fc%2Btk10lH89KY8tTuhyWIGmmXmza266WX2xhBVM%2Bu2Qy%2Fe5NPp05uDS1r%2FxFI3AfikKqRMQiI3xRozMpNllEtVULpFrnSogcQBvAe6rUHmOBbJQAKFEpx1ZYhdx%2F0%2F3HXiXeojkjzHctad%2BUrqlkKVVUInjYFS1EpEjMzPQwa5EpnMPEQjkQXEizUNcyH21BEakudKhBQyYyWmFLxvlh6KjSCDkpChaWIKro4X5yk3AzC7GRIbr81gnsy6n8GLCrb1Hx%2Fp2MA4qbacE8Yqqe2UHU09vWCHgMgUsqwFdyDwqScqLYtp0VBJMrPujVAQQPGENGFKt7nZ6wQk5CmkAaUtnJ4MkHkqL9a7JPtR8cKwCvS8E5bBhqfd7nqBWINAd%2Faz1somGSwRbFSDZ0HI%2Bh4SaXLIv1A5VbBm5D9TktQslyxURW6jcBxxJrwyuHMSyYB%2FRdSloAVLAV40ztx6U1TlaUl1ZGjs8VBkwrOfzvG1E1nBUmtC5AwfbzXd0ITzH%2BN1ZWNeChixyvaoTZrLodACtHbsMR2x4grzRmPAnGzCxKpHYg4N68YbPZv5qafG6QU71g93vBa%2B9Ta%2B196%2BxO1Wlw2I8zpc15DT6r2Uon6WPCFL3JiUm9Rzjw2sxkgmBGwofYdKvYAklhDcneIBDfnS2WzjGxrM0HcMJZrAMzhOjTfDUjMkRC8g3HSPFAGx0da%2BoHb6AFcpEsIqZwVhCv7ImszIo0GeWCZcrknqdDwRprnwaW%2BdVbHhiwDzs%2FBm0tVRbaYB927vWZtHvG7mJOD9hrsmdsqzNJ%2BOkwf6xZuToSHqgKExQap4A9PZmmt1QqunuWWLHVrQoepC57ivJjXXU4E8SSZsVR1RcnkDGIyMcnnPXuHznrd0w1jnqQbhst9UGvhX1D6B7zQ83QrhmeqwX%2Bs2awX3nN0Dnmh4JhKBheWDD8OE2GgmEoGF5VweCe%2F76C4aXE%2FInmomBK4FgDNw%2Fc%2FD9zsz1w88DNr46bPe%2B1XeY8XBLhG1oRXed2R4q8%2FEJ9zXY6Z5q50Y66eV98s9R8s97yuVPjc5YCiS85A8pbkqeNpHqBmqA3SvPyhYbuSrK%2FC7jYRONiG7eulHZz3%2B3OvreuZc%2Bn8lGI9N%2FYOgnaaaleDvgdbsAxYkkiRmvTCP%2BqAPT8dgA6%2FnEAVm9mmvHnT04Ov5%2BLN3%2BIt78p3iaTPxxv50O8%2FU3x5ru%2FLN70HeHwjta0NV50u4t%2FAQ%3D%3D%3C%2Fdiagram%3E%3Cdiagram%20id%3D%22P7FuWJOVbNT2LyfNW4WD%22%20name%3D%22Data%20Diagram%22%3E7V1rc5s4F%2F41nul%2BSIe78cfYTprsJm%2BTpml394tHAdmmweCCyKW%2FfgUGm8sBY1siTl910hkjY4GkR%2Bc85%2BjoqKeOFi%2BfArScX%2Fs2dnuKNAscu6eOe4oi0%2F9pwZ3zC6eFUloaOTYOCzcS33eJsywWWr7nYYsUylAQ%2BM%2FF25ZohgsFU9%2B1K3fcWcjFldLvjk3mq1JT6W%2FKL7Azm2dPlo3B6psFym5OWxLOke0%2F54rUs546CnyfrD4tXkbYjXsm65cX7%2FoffewZn8g3fC5HwfLi8eZkVdn5Lj9ZNyHAHtm7asNTl84PX304%2F3p1%2B2%2F%2F8Sb69OVETut%2BQm6UdljaWPKa9eDz3CH4boms%2BPqZQqCnDudk4dIrmX4M%2FMizsZ1e2Sicry%2BmvkdSRFA4qMOQBP4jHvmuHyRVq2NjaOjG%2BptsgNT4t47r5u6cTqeKZdHyWYBsh%2FZD9p3ne7T%2BYdoMHBD8Uhr4Lb0mr4eSAhz7C0yCV%2Fq7tBZFTet5XV1r6eXzBkuyrq7K5jkcGWoKI5Tid7auejNG9EM6TPCQvc7%2Fmv91Nfzz%2FmL298Ixr6RLxztRKyN2E%2Fh2ZJGwMnLhs7NwUdI%2FyVCk38RDg1xn5tHPFu0cTPtxGHedQ6fNafrFwrHt%2BO6hNXdc%2Bwq9%2BlHctJAg6zG7Gs79wPlFa0YZGOjXQTbkyqBwx138S1ocAyHAIb3nJhsauVR0jV4KN16hkKQFlu%2B6aBk6D0lL4pIFCmaON%2FQJ8RdpUQ6du4AAwE89LjSlgIuBVMWFKlVxIesSJ1xowEw20CKerS5JeiJ%2FFdJRxz55XWJ5%2FcWscFt6VYIU7R5S7OHipE6nY372pkXtERdSWeN4sys8jTtN25R8SfsxLvLpz6duIo%2Fn9IfYS0QRQQRtoLH0HY8k%2FawP6R%2Ft%2BZH0Ue%2FptCEjei1vrulffHtAxYpHG4ScBC2Y4u4ZhwTEUePk3I6jFDfKoB1uFJ0TbPQKbJYrcTKhP1OkD1e%2BN%2FuDgiJBzUNQQIPxM4qVXyJcTsJk1p%2FSG2Rp%2BbL5kn5KoGQhgmd%2B8JrW%2Bw0F1hwFTKr20AKzrpOSFitwlsTxPdZV%2F4yQRxwSo%2BDDJZ0MM8ym3shzyGQZOFRRZ5PYewiX%2BUmdXn8Y%2BxGdJkyeSkU%2BSXp%2FSGkdRt4fHGSGm4iC9yUxyuSHlwTRtXYSZGAcLkFgDlllJF1ySEmSx8NRGw4pSbp0dg5wyBW%2FpP84EkldVYtEEiAMhgYQSY0XYTCqRBK9LrAniGSXRFJXzQIuTBMwMDolkn1BJN%2BeSBqtcdRAJCHccCOSZpVIrsTJgUQyQVKJc2Q1B3hK0edZCf%2B4v78cM34A7Zm5b6cNOICqNbVh1WG0%2Fv05GVS9TVkZcRZ4kj4neUJaxrAJro%2BSzvkR%2Bh6rav3AxkERNYJR7s8odxYlEKOERAk%2FRqm8KaMcKhL914ZRnp%2Bnd8Z1QmzyLZimOtC3Ms3Mq9kN0xxUhvNzPMUFz%2ByQZ2pS0ZEN8UwF4pncUJGtEAmi%2BZZEc9AaSA1EEwION6IJrFkBjIEhE%2BHGMteuszMvWrCqFC2o6iPsCeWSCmzf49DJGVMtMVRB%2BfanfDtPaojyQZPa5Eb5oOWr7iif2pekUSsnonEqSedv5UTsS4Ot1E7Xu6R2AFW%2FmztL4UbsmN715aJ72QS0tAYgQ%2B5zQwa0LNA9vctP7t%2BO4zUGw2zVEuu5exD3g1DFj%2FuBUQ4JgGznqTUNqXCQrBI6pN7%2BtYSp5INIEm3uqvLiA2lx8uLF0mNqSz37fW9NsjGdEiQK8CRPOWtaM17fwuLR77bP1jBAtk2VXwhEFrRvVyWK4hgaCNpg722Yag3glg0RxlZvb2NrdzUKWVsgOZMZmFvwO1fDvhKX7GSMCXJcQd279MzKMUDz5F3XjCpAJMg5q3Jj79XoEOGc7dw5u56mBzF0CDn8GHo1fCRRTnYiWBIVxcYdmYtSZbzqzKS6TZAnk%2BoKsZ0sKhQ6%2FyCdv%2FPEhHQ%2BNDH7vFS%2BUl02%2BYJ%2FRrQbhLbv0lGnaNt1vQySQV66PnO1C13%2FlrpeaQ%2BlBl0PIYebrldAF%2B%2FONjGsnvYwi6GKgpWMyyl2brY913aE0cOPeH%2Fsu27EAodhvIH3XTciCgs8UXhYuLOt3UUjxLYg0agzYFsP%2F8xnF0MXqV8%2F3z9%2Fe7q4NZbqSTW2KdtcMblOgooF5%2BqOc%2BlacXEU5Fwa5F9RGHAuEB%2FQvntBufhRrsZJetj6JyfvCvjGVabewU4FBttrwbivuh22QlW2UpVsIA2uRQCQNnhpyqoNMUp3igsV2Z2KVLTiNkTYLdGpihQJLY5ARTJJaAHhhpuKrK5sljJPsEy50GnmCaEX99eLTNIqQDhmoRfPb5ffjcWkj5XT60j78fTrK5oAFmQGrrgLWsHLhOB1H%2BLg%2Bi7nplhV19pP0V7sJcquFgXxQKOI%2BGE6mDvgF8YA%2B3BrqttKK%2FNyNeDahIQbA504%2FL7QnQvrSjfmf1%2BMbs3J2eU1N1CkKcQELtolhdPVbaiAF915wQL0JjCARRITJEDRChSaZGwDxaBLTNSvzRwoKlYOB4GKdml%2FjO2iAqTHvGBRH0B%2FGCyyXT8CF%2B12cmUD3IALcFctC1zYI6NP%2Fv3pKEH%2FfHh39vV%2Ff34GmUXZ%2FTJHy%2Fjj1MUvp3FqXto%2F2LPTj2PLRWHoWL2aTXlxb9ZuyjPpddZ0VV%2FVm31nfNRNxZBMY6AbuiL3jdLIxZvybLNvaJVhjvf%2BnOqaunGcYLuUPnjfYcyNE5QaIysLsIuI81R8JjR26RNuYhzndUoBJFo53DP0o8DC6Y82ANhWTzmShKBghkmlGjqw6DV3WzrJykhb90o7m10eS%2BPzx4XxlSzI7UU4JJe3NakAdpJKCmhLn8UxeA4O28qkGB9X6AG7%2FARTDvaK3iumDrHxFEXJiyYWdOwBUMcng7giN36rIbIeZ8mUapv%2BOE2rnb5Rby0%2F8rivlwe14kv6qEqlhHbZ2sSBkM%2BqyczwkpvIn05DTA7EINjgw%2FmSorOA4NGrRbME2iSzYpoHh5u6VPVyjHxLm4tFhDyIlxYb1jkrTFpVtlFd7n%2BsaE1VGWgyVZdaX9JNUy9r2JIKRZKuKDakQo2xfJ4bXKFCE7efeXQ6lIETQK9Zqv2W5qj7nMSgHak2lcvaNC%2BY3lyfao3y7UT6qOulowZkNvq0WGkWfcxUn8IZPVpYFBwzepjKg2q0OlrC1rFpx8ZDx0dLDEonS7Q8QYBJLg9wxICYtSTnj9gfULsQz2HNoZSnDTpYgts6PDyRIb0i1uGZrsNvwVH9dD2KdXjw9ZQKbKwopFOJS6K2qROEhFOcGmXpvKpeh5Kz7Y149k1W%2Bdp6hYAH5nPu94kgYD8Du4wgAF%2BvuoX7awwModQ7V%2BqD4tIgGFwHJl%2FlptRFkv%2FjVOrGzkqdV%2B5V8PWqSf5jUBRSg4rgc6Ei2%2BK5bdpRFioS3FlWNXnj8DihGzuMPJclteTaXzvVCr79TrfEC5v3CHbEM9meBeGG34b4Cmw4WXieYz1y0oxLFIbPfmALtchq%2BzKTPVkQjlnsXgYXKyDroDvX%2FdDUNX3zTdP5K%2BboLMnsCyTjPjs1hskCAC%2BjzuyXlharWkuFFjaZOPDBYauyc%2B7D1jA4Z%2BrIhA7HWa%2FJVQdeGujJN2%2BRW10uL%2FGqg4yXFM5o7APzkMVZfOCIVk%2FOYROteek90b7yg1cRrtnSgbM9jLfTcE0GEXMwMi6QR8csOIvxEQp0tBUdSgEesOToFB9VC2Y952nxpbeMSGUQhZXLjyyYReUCnc8AAYTJMa8wQqrGylvYuP%2B%2F5zNsAVnDtN7JAAbFDgMDGH4%2FNhnhOGVJdzIJ6MTir2SW75%2FWvlht8VVXd%2Bx%2BiEJsxB9dlvlVtx354Qn%2BQ4iDpyTYr%2Fa0gnwtoP%2Bk8oD8L5ZR%2FIMQT5KUwXUumKMbPULlnLs5bvjc9RF5twcepFBMkkr3yucPi5R8nJd69tFNkFML0k0sThWG368asZ%2BnxJ8jIjhxx6GO2nZS3O%2BWFFezxwhSfPSkuCa2voEUQ6jiR4rBszQ2mrTEIv1EELVkpw0VNB9bC2j0lD%2Btfp1neWV6055wNTCjxjN7a99uG4mpYyvFttXSBsEPOPKD5mkK8QNomvLjB9VVr8QLKihBh5RA0cxSNAhECqBlNbm8I48dMKB1NUEKjpwU9HcmBRCq%2BJGC%2BqW9IzCv8dNvcoxpzHva%2Btw4NCKWAhCDOqxRrT1VzS3L32n5iyWdcsnKIcT33o2PMuOtEyvA9GOC4Mwd%2BQYAWL9OtLSbXof1c1cTeEN0myk8k0fWhbrxedTEij2wcMg5hyeu9M2kSS4K24Gj7dCszSHbAeSICoss5lD2harfKO9bPLV%2FRCFZCGOi211X%2FVLuAyhnDLjobjAwJUCYHMepqsKSqAFZ%2FdQ%2BiiV38PXAnXy1zkW0lkQHOBhXlezrYKyuInPxL0Isd58l0Ma25LpTOBU5E4M9JmfbNUdZYsAL0PjT%2FeV0GM3UG%2FNiFGrz22fcJq1mhyHZWLXeVUi2VsqSqsnAePIKyAbHk1em7ZG%2FWPieiLdtiYuahKZdhGODsFAqsLgP8YhaqILvd8f3ZUXrFwm%2FCeACtAtZbMkBgQHGQwrCfyyEv34yH8XKAfh69Rncj8D9GoW42THXkd%2B1bnPs0TneS4kotphRNY8RruL9hkxYZkwssz2kaFuPrcnLMKs6bJNgj8k4mQciA0invE1XimYelAsV5G0sEoCA8BCO2vfH23Z31HbK27Y4ao8g4GPFAcK3jftoSmuyJXcX59V0sezbNYfY3bsLniTALWIUmNElBOSOe0hHtuDBzSEjLr9BhApyLylRJLVXdukqvfIBEeUzIVYv8M7OaCh7efc9o0E2yilZyjXVnNKwR857EBBVN%2BCu3mH4DJk9z184diex2nRiAy%2B2SflUKcIYpJtQ6Pkeqwr0MvDjsdzALEDL%2BbVvx6dinP0H%3C%2Fdiagram%3E%3Cdiagram%20id%3D%22-1f0VvfiN8C0hBRgz3Ku%22%20name%3D%22Package%20Diagram%22%3E7Ztvd6I4FMY%2FjS%2FtESIIL9V2rLvOaP0z3fpmT4SgbJHYEKzup98gQcVEi47YjmvP6TlyoSDP%2FT25N4QWQH26aBA4m3zHNvIKamlMXLsA7guqqrBfHui5%2FyIeLPFo6NooSB1IMfaoO0sHLez7yKKpGCQEv6cPm8ExSgUc7NnCET0LekiIPrs2ncRRQ61s4o%2FIHU%2BSKyu6Ge%2BZwuRgfifBBNr4fSsEHgqgTjCm8afpoo68SJlElzdgkoehWXzSfpDmcPCz266Exfhk3475k%2FUtEOTTk08N%2FfagTzw1rIB3t9LFA8dSi1yFOfRCrlcHLqfRZdRSB1qvkdrxzdNloijTYRZ9jJRHpABqDvZpj%2B9X2DaFo0RqhWGwCqw1BjzQwYFLXeyzkIcctqc2oVOPn2GEQ99GdmuUBDw4Ql7Tf0RwdclVjBFDoetvbXsenAXuaPVFossQZIUkcOeoi4IYzCjquJ5Xxx4mq9sBaPXD4gEl%2BBVt7QE6MAFTr5ZRf56nOSIULbbo4%2FloIDxFlCzZIcleg6O1jLd1vvm%2BAVXXeGyyBWklORByc4zXp94AwD5wBo7gIXHtFhDV2cxzLbjK1ZWj4BgWsiwZCiNDK2slKQoHfZUdhTQJZQkJQEKCYp6BhL9N90%2B7PYR%2B1TKaz%2B3v%2F9RQp6hoAgmDANVhcPUDguNYlpyCAwPCYTdlx6CcxkATMFhnPIUB0PLCQBcwqBMEKeJ1Yh8TW7k7h7yHEf1Y3m0BdYmAibcI8thIN0%2F3DjJR%2BSU62F3VSn51Ne1ibcec2HECRIWcrL%2Fn6WlSxULeZdb4vZIkF9EUh8KDKTy7BVRxJHwKET%2FxbRzMZRwsg516eMmBcPqgNcemZ41Gi26jY%2FxBX5S3oimHYN0un99agloZ3Baz%2BttYSzHE6oKnU%2BjbN3PlZy6W0Dvti9lrLwhfzGAxsfv7N31HWU29k2ibl8nkgIi9QdN3CGTyhBYNydU39DZEhiMFQrcMNHLynNal%2B3kgmeFrSYudgiG3eZ3YzzdZhqrR8x5MaHBjIfO4m8Mcf12gt1nIsfyKT3uYduJYe2PgAzOdOrcBlWx116jc5TXB3%2FsEuM7EJkxgpnb22ns%2BaY9oa7bVU3Kc3OvSnumsk3v9eQTHDdMNXl5aP5rDllr%2B%2Ba0ourSPZ64VNK%2F%2BgWxmnE5p5fRjnKoAyVwpP6tKOVAEDlKP4lZQSJg4g1s%2FkHc%2FtYfNKlvbOJNZd2utkYNZpVSJE5l2SOMGq2rDGUXk1mPl2GOplY%2BbLNlCCijn1WSpIhEsU3RMUMCBuPGQtSkwjsUhXbIVCQ2X7rdU8UEiH79r95%2FSaKnZRb1Qo%2FVpY7cC9nRa0RB%2BM%2BllTPoF5kRKlk5LxsRFJkYgs75X1Gu9DpugH4bB0nytPAdvKKy1epKJEUvQ4FZVL2tYWY%2BVo2OlJIiGjUioe%2B5xSwcnaXoQzf9VUZX38OLy%2BT2eMgNcu0Ed9mMYMpiOXeL71WUHmUPLZQlrSim3RShx3YEX0x4ic9c67uWUcwl74htEedpU31k%2FzOMVIqkWqrSaRhnqolnkKSx55eWLJYnvBTuDnSYpUIdy%2BCv0L%2FrdSvUl%2BMu6byxa%2FQGxHp9MeXk6eln78wTd815bDnqyzc0b9THam386AA%2F%2FAQ%3D%3D%3C%2Fdiagram%3E%3C%2Fmxfile%3E

#### Containers Diagram

#### Class Diagram

### Data Diagram

### Package Diagram

## Project Structure

```bash
├── com.onlineshop.payment/
│   ├── application/
│   │   ├── command/
│   │   │   ├── CreatePaymentCommand.java
│   │   │   ├── CreatePaymentCommandHandler.java
│   │   │   ├── RefundPaymentCommand.java
│   │   │   ├── RefundPaymentCommandHandler.java
│   │   ├── commandbus/
│   │   │   ├── Command.java
│   │   │   ├── CommandBus.java
│   │   │   ├── Commandhandler.java
│   │   ├── query/
│   │   │   ├── CreatePaymentCommand.java
│   │   │   ├── CreatePaymentCommandHandler.java
│   │   ├── querybus/
│   │   │   ├── Query.java
│   │   │   ├── QuerydBus.java
│   │   │   ├── QueryHandler.java
│   │   ├── usecases/
│   │   │   ├── CreatePaymentUseCase.java
│   │   │   ├── GetPaymentUseCase.java
│   │   │   ├── RefundPaymentUseCase.java
│   ├── domain/
│   │   ├── interfaces/
│   │   ├── iPaymentRequest.java
|   |   ├── iPaymentResponse.java
│   │   ├── models/
│   │   ├── Payment.java
|   |   ├── PaymentId.java
│   │   ├── ports/
│   │   │   ├── clients/
│   │   │   │   ├── ApiClient.java
│   │   │   │   ├── PaymentProvider.java
│   │   │   ├── persistence/
│   │   │   │   ├── PaymentPersistence.java
│   │   ├── shared/
│   │   │   ├── domaineventbus/
│   │   │   │   ├── DomainEvent.java
│   │   │   │   ├── DomainEventBus.java
│   │   │   │   ├── DomainEventCollection.java
│   │   │   │   ├── DomainEventId.java
│   ├── infrastructure/
│   │   │   ├── bus/
│   │   │   │   ├── InMemoryCommandBus.java
│   │   │   │   ├── InMemoryEventBus.java
│   │   │   │   ├── InMemoryQueryBus.java
│   │   │   ├── exceptions/
│   │   │   ├── constants/
│   │   │   │   ├── ExceptionsContants.java
│   │   │   ├── BusinessExeception.java
│   │   │   ├── RequiredException.java
│   │   │   ├── kafka/
│   │   │   ├── PaymentProducer.java
│   │   │   ├── models/
│   │   │   │   ├── converters/
│   │   │   │   ├── ModelConverter.java
│   │   │   │   ├── ModelConverterImp.java
│   │   │   │   ├── provider/
│   │   │   │   │   ├── PayU/
│   │   │   │   │   │   ├── merchant/
│   │   │   │   │   │   ├── payed/
│   │   │   │   │   │   ├── threedomainsecure/
│   │   │   │   │   │   ├── transaction/
│   │   │   │   │   │   ├── transactionresponse/
│   │   │   │   │   │   ├── PaymentRefund.java
│   │   │   │   │   │   ├── PaymentRequest.java
│   │   │   │   │   │   ├── PaymentResponse.java
│   │   │   │   │   │   ├── PayURequest.java
│   │   │   │   │   │   ├── PayURequestRefund.java
│   │   │   │   │   │   ├── PayUResponse.java
│   │   │   │   │   │   ├── PayUResponseRefund.java
│   │   │   │   ├── shared/
│   │   │   │   │   │   ├── orderms/
│   │   │   │   │   │   ├── userms/
│   │   │   │   │   │   ├── Config.java
│   │   │   │   │   │   ├── Payload.java
│   │   │   ├── persistence/
│   │   │   │   ├── DAOS/
│   │   │   │   ├── entities/
│   │   │   │   ├── memory/
│   │   │   │   ├── postgres/
│   │   │   ├── rest/
│   │   │   │   ├── clients/
│   │   │   │   ├── constants/
│   │   │   │   ├── controllers/
│   │   │   │   ├── DAOS/
│   │   │   │   ├── DTO/
│   │   │   │   ├── mappers/
│   │   │   │   ├── transform/
│   │   │   ├── validators/
│   │   │   │   │  ├── PaymentValidator.java
└── OnlineshopApplication.java
```
## Base
This project was generated with Spring Boot and Gradle, H2 was used as data persistence engine.

Spring Actuator is implemented for the generation of the metrics, Prometheus for their processing and Grafana for their visualization.

## Installation for local test
  
Go to the project folder and run the following command:

### Project build
#### Windows
> ```gradlew clean build```
  
#### Linux and Mac
> ```cd onlineshop```
>  
> ```foo@bar:~$ .\gradlew clean build```

#### Running the app with Gradle
From Visual Studio Code or Intellij go to the OnlinedhopApplication class and run the project.

#### Tests

##### Create a payment

From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/:

```json
{
    "paymentMethod": "TC",
    "paymentValue": 23.0,
    "paymentCountry": "CO",
    "description":"Payment test description",
    "orderReference": "034acc05-35cc-41b7-ab30-5cc4e729fb43"
}
```

#### Get a payment

From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/{paymentReference}:


#### Make a refund to a payment made


From Postman we can send the following request in JSON format to the endpoint http://localhost:8080/payment/refund:

```json
{
    "paymentReferensce": "f5d3d623-6e94-4b14-8d83-4be4561f5559",
    "description":"Reason for requesting the void of the transaction"
}
```
