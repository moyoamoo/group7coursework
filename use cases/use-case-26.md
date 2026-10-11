# USE CASE 26: Produce a report the population of the world and of a continent/region/country/district/city

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *employee* I want *to produce a report on the population of the world and of a continent/region/country/district/city* so that *I can easily access this population information.*

### Scope

Organisation.

### Level

Primary task.

### Preconditions

Database contains population information of cities and countries in the world.

### Success End Condition

A report is available to all employees with the population of the world and of a continent/region/country/district/city.
The report should include:
1. The name of the country/region/continent/district/city
2. The total population of the country/region/continent/district/city
3. The total population of the country living in cities (including a %) (if applicable).
4. The total population of the country not living in cities (including a %) (if applicable).

### Failed End Condition

No report is produced.

### Primary Actor

Employee of Organisation.

### Trigger

Employee has access to software to view report.

## MAIN SUCCESS SCENARIO

1. Employee selects the report type they want to view.
2. Employee selects the country whether they want population of world/country/region/continent/district/city
3. Report of world is shown to employee if world is selected 

4. Employee chooses if they want to see country/region/continent/district/city population information
5. Employee enters desired country/region/continent/district/city
6. Employee is shown desired report 

## EXTENSIONS

5. **Employee entered an invalid country/region/continent/district/city**
    1. Employee informed by software input is invalid
    2. Employee is prompted to enter another input

## SUB-VARIATIONS

None. 

## SCHEDULE

**DUE DATE**: 