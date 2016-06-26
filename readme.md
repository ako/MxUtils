# Mendix Utils Microflow actions

## ChartJS

Some Microflow Actions:
* Build NPE datastructure required by ChartJS using OQL statement as source.
* Build JSON document using OQL statement that can be mapped to ChartJS datastructure
* Build NPE datastructure required by ChartJS by executing OQl statement and providing a import mapping so it can be mapped to the appropriate data structure

### OQL to Entity

OQL needs to fetch the following columns:
* name of chart
* xlabel
* xvalue - timestamp
* yvalue - decimal
* color
* label
* sorting value of dataset

An example:

    select   ''SensorState''       as chartname
    ,        DATEPART(YEAR,TimestampReceived)
                + ''-'' +  DATEPART(MONTH,TimestampReceived)
                + ''-'' +  DATEPART(DAY,TimestampReceived)
                + '' '' +  DATEPART(HOUR,TimestampReceived)
                + '':'' +  DATEPART(MINUTE,TimestampReceived)
                                   as xlabel
    ,        min(TimestampReceived) as xvalue
    ,        avg(Temp)             as yvalue
    ,        ''#ff0000''           as color
    ,        ''avgtemp''           as label
    ,        1                     as sortingvalue
    from     IotSensors.SensorStateReported
    where    DATEDIFF(DAY,TimestampReceived,''[%CurrentDateTime%]'') <= 3
    group by chartname, xlabel
    union all
    select   ''SensorState''       as chartname
    ,        DATEPART(YEAR,TimestampReceived)
                + '':'' +  DATEPART(MONTH,TimestampReceived)
                + '':'' +  DATEPART(DAY,TimestampReceived)
                + '' '' +  DATEPART(HOUR,TimestampReceived)
                + '' '' +  DATEPART(MINUTE,TimestampReceived)
                                   as xlabel
    ,        min(TimestampReceived) as xvalue
    ,        cast(avg(Sound) as decimal)            as yvalue
    ,        ''#00ff00''           as color
    ,        ''avgsound''          as label
    ,        2                     as sortingvalue
    from     IotSensors.SensorStateReported
    where    DATEDIFF(DAY,TimestampReceived,''[%CurrentDateTime%]'') <= 3
    group by chartname, xlabel
    order by xlabel

The result will be returned in the following data structure:

 ![Chartjs datastructure][1]

## Conversions

* Convert Long containing unix epoch to DateTime.

 [1]: docs/images/chartjs-datastructure.png