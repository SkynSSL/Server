# SSL2020
Skyscapelive2020

# DONOR FEATURES
Donor Ranks
    CONTRIBUTOR(5, "B60818"),
    SPONSOR(6, "063DCF", CONTRIBUTOR),
    SUPPORTER(7, "118120", SPONSOR),
    DONATOR(8, "9E00DE", SUPPORTER),
    SUPER_DONATOR(9, "9E6405", DONATOR),
    EXTREME_DONATOR(17, "9E6405", SUPER_DONATOR),
    LEGENDARY(18, "9E6405", EXTREME_DONATOR),
    UBER_DONATOR(19, "9E6405", LEGENDARY),
    MAX_DONATOR(20, "9E6405", UBER_DONATOR),

Bonus player kill points - these might stack...
    LEGENDARY       +4
    EXTREME_DONATOR +3
    SUPER_DONATOR   +2
    DONATOR         +1

Bonus Slayer Points - these might stack
    LEGENDARY:       +30
    EXTREME_DONATOR: +15
    SUPER_DONATOR:   +10
    DONATOR:         +5

Remove an existing slayer Task
    EXTREME_DONATOR: 70
    LEGENDARY:       50
    NON-DONOR:       100

Donor Commands
    ::bank
    ::donatortitle -- seems to fill from src/ethos/model/content/titles/Title.java
    ::donatorzone ::dz
    ::killtitle

Commands for everyone
    ::yell
    ::droprate

Drop rate Modifiers
    MAX_DONATOR:     .15;
    UBER_DONATOR:    .12;
    LEGENDARY:       .10;
    EXTREME_DONATOR: .08;
    SUPER_DONATOR:   .07;
    DONATOR:         .06;
    SUPPORTER:       .05;
    SPONSOR:         .04;
    CONTRIBUTOR:     .03;
