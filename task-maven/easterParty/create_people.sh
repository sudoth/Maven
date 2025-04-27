#! /bin/bash

function create_parent() {
    echo "{" >> "$2"
    echo '"children": [' >> "$2"

    for (( j = 0; j < $1; ++j ))
    do
        echo -n "{ \"name\": \"child_$j\" }" >> "$2"

        if [ $j -lt $(( $1-1 )) ]
            then
                echo "," >> "$2"
            fi
    done

    echo "" >> "$2"
    echo "]" >> "$2"
    echo -n "}" >> "$2"
}

filename="attenders.json"

touch $filename

echo "[" >> $filename

for (( i = 0; i < $1; ++i ))
do
    create_parent $2 $filename

    if [ $i -lt $(( $1 - 1 )) ]
    then
        echo "," >> $filename
    fi
done

echo "" >> $filename
echo "]" >> $filename
