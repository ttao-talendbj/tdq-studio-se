/**
 * <copyright> </copyright>
 * 
 * $Id$
 */
package org.talend.dataquality.indicators.impl;

import org.eclipse.emf.ecore.EClass;
import org.talend.dataquality.indicators.DateGrain;
import org.talend.dataquality.indicators.DateParameters;
import org.talend.dataquality.indicators.IndicatorParameters;
import org.talend.dataquality.indicators.IndicatorsFactory;
import org.talend.dataquality.indicators.IndicatorsPackage;
import org.talend.dataquality.indicators.MonthLowFrequencyIndicator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Month Low Frequency Indicator</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class MonthLowFrequencyIndicatorImpl extends FrequencyIndicatorImpl implements MonthLowFrequencyIndicator {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected MonthLowFrequencyIndicatorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return IndicatorsPackage.Literals.MONTH_LOW_FREQUENCY_INDICATOR;
    }

    @Override
    public IndicatorParameters getParameters() {
        parameters = super.getParameters();
        if (parameters == null) {
            parameters = IndicatorsFactory.eINSTANCE.createIndicatorParameters();
        }
        DateParameters dateParameters = parameters.getDateParameters();
        if (dateParameters == null) {
            dateParameters = IndicatorsFactory.eINSTANCE.createDateParameters();
        }
        dateParameters.setDateAggregationType(DateGrain.MONTH);
        parameters.setDateParameters(dateParameters);
        return parameters;
    }

} // MonthLowFrequencyIndicatorImpl
