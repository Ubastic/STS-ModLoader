#!/bin/bash
# Author: github.com/reckter (Hannes Güdelhöfer)

# clears out old decompiled files WARNING: this will override all changes you made (todo)
rm -rf decompiled/*

# decompile every class to `decompiled`
java -jar ./tools/cfr_0_124.jar \
    --caseinsensitivefs true \
    --outputdir decompiled \
    compiled/desktop-1.0.jar

    #    --jarfilter com.megacrit.cardcrawl.* \
