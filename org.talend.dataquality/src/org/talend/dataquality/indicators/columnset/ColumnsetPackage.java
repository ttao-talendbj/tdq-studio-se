/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.dataquality.indicators.columnset;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.talend.dataquality.indicators.IndicatorsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.talend.dataquality.indicators.columnset.ColumnsetFactory
 * @model kind="package"
 * @generated
 */
public interface ColumnsetPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "columnset";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://dataquality.indicators.columnset";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "dataquality.indicators.columnset";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ColumnsetPackage eINSTANCE = org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl.init();

    /**
     * The meta object id for the '{@link org.talend.dataquality.indicators.columnset.impl.ColumnsCompareIndicatorImpl <em>Columns Compare Indicator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsCompareIndicatorImpl
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getColumnsCompareIndicator()
     * @generated
     */
    int COLUMNS_COMPARE_INDICATOR = 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__NAME = IndicatorsPackage.MATCHING_INDICATOR__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__VISIBILITY = IndicatorsPackage.MATCHING_INDICATOR__VISIBILITY;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__CLIENT_DEPENDENCY = IndicatorsPackage.MATCHING_INDICATOR__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__SUPPLIER_DEPENDENCY = IndicatorsPackage.MATCHING_INDICATOR__SUPPLIER_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__CONSTRAINT = IndicatorsPackage.MATCHING_INDICATOR__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__NAMESPACE = IndicatorsPackage.MATCHING_INDICATOR__NAMESPACE;

    /**
     * The feature id for the '<em><b>Importer</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__IMPORTER = IndicatorsPackage.MATCHING_INDICATOR__IMPORTER;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__STEREOTYPE = IndicatorsPackage.MATCHING_INDICATOR__STEREOTYPE;

    /**
     * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__TAGGED_VALUE = IndicatorsPackage.MATCHING_INDICATOR__TAGGED_VALUE;

    /**
     * The feature id for the '<em><b>Document</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__DOCUMENT = IndicatorsPackage.MATCHING_INDICATOR__DOCUMENT;

    /**
     * The feature id for the '<em><b>Description</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__DESCRIPTION = IndicatorsPackage.MATCHING_INDICATOR__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__RESPONSIBLE_PARTY = IndicatorsPackage.MATCHING_INDICATOR__RESPONSIBLE_PARTY;

    /**
     * The feature id for the '<em><b>Element Node</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__ELEMENT_NODE = IndicatorsPackage.MATCHING_INDICATOR__ELEMENT_NODE;

    /**
     * The feature id for the '<em><b>Set</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__SET = IndicatorsPackage.MATCHING_INDICATOR__SET;

    /**
     * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__RENDERED_OBJECT = IndicatorsPackage.MATCHING_INDICATOR__RENDERED_OBJECT;

    /**
     * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__VOCABULARY_ELEMENT = IndicatorsPackage.MATCHING_INDICATOR__VOCABULARY_ELEMENT;

    /**
     * The feature id for the '<em><b>Measurement</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__MEASUREMENT = IndicatorsPackage.MATCHING_INDICATOR__MEASUREMENT;

    /**
     * The feature id for the '<em><b>Change Request</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__CHANGE_REQUEST = IndicatorsPackage.MATCHING_INDICATOR__CHANGE_REQUEST;

    /**
     * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__DASDL_PROPERTY = IndicatorsPackage.MATCHING_INDICATOR__DASDL_PROPERTY;

    /**
     * The feature id for the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__COUNT = IndicatorsPackage.MATCHING_INDICATOR__COUNT;

    /**
     * The feature id for the '<em><b>Null Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__NULL_COUNT = IndicatorsPackage.MATCHING_INDICATOR__NULL_COUNT;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__PARAMETERS = IndicatorsPackage.MATCHING_INDICATOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Analyzed Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__ANALYZED_ELEMENT = IndicatorsPackage.MATCHING_INDICATOR__ANALYZED_ELEMENT;

    /**
     * The feature id for the '<em><b>Datamining Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__DATAMINING_TYPE = IndicatorsPackage.MATCHING_INDICATOR__DATAMINING_TYPE;

    /**
     * The feature id for the '<em><b>Indicator Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__INDICATOR_DEFINITION = IndicatorsPackage.MATCHING_INDICATOR__INDICATOR_DEFINITION;

    /**
     * The feature id for the '<em><b>Instantiated Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__INSTANTIATED_EXPRESSIONS = IndicatorsPackage.MATCHING_INDICATOR__INSTANTIATED_EXPRESSIONS;

    /**
     * The feature id for the '<em><b>Matching Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__MATCHING_VALUE_COUNT = IndicatorsPackage.MATCHING_INDICATOR__MATCHING_VALUE_COUNT;

    /**
     * The feature id for the '<em><b>Not Matching Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__NOT_MATCHING_VALUE_COUNT = IndicatorsPackage.MATCHING_INDICATOR__NOT_MATCHING_VALUE_COUNT;

    /**
     * The feature id for the '<em><b>Column Set A</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__COLUMN_SET_A = IndicatorsPackage.MATCHING_INDICATOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Column Set B</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR__COLUMN_SET_B = IndicatorsPackage.MATCHING_INDICATOR_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Columns Compare Indicator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMNS_COMPARE_INDICATOR_FEATURE_COUNT = IndicatorsPackage.MATCHING_INDICATOR_FEATURE_COUNT + 2;


    /**
     * The meta object id for the '{@link org.talend.dataquality.indicators.columnset.impl.ValueMatchingIndicatorImpl <em>Value Matching Indicator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.dataquality.indicators.columnset.impl.ValueMatchingIndicatorImpl
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getValueMatchingIndicator()
     * @generated
     */
    int VALUE_MATCHING_INDICATOR = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__NAME = COLUMNS_COMPARE_INDICATOR__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__VISIBILITY = COLUMNS_COMPARE_INDICATOR__VISIBILITY;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__CLIENT_DEPENDENCY = COLUMNS_COMPARE_INDICATOR__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__SUPPLIER_DEPENDENCY = COLUMNS_COMPARE_INDICATOR__SUPPLIER_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__CONSTRAINT = COLUMNS_COMPARE_INDICATOR__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__NAMESPACE = COLUMNS_COMPARE_INDICATOR__NAMESPACE;

    /**
     * The feature id for the '<em><b>Importer</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__IMPORTER = COLUMNS_COMPARE_INDICATOR__IMPORTER;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__STEREOTYPE = COLUMNS_COMPARE_INDICATOR__STEREOTYPE;

    /**
     * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__TAGGED_VALUE = COLUMNS_COMPARE_INDICATOR__TAGGED_VALUE;

    /**
     * The feature id for the '<em><b>Document</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__DOCUMENT = COLUMNS_COMPARE_INDICATOR__DOCUMENT;

    /**
     * The feature id for the '<em><b>Description</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__DESCRIPTION = COLUMNS_COMPARE_INDICATOR__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__RESPONSIBLE_PARTY = COLUMNS_COMPARE_INDICATOR__RESPONSIBLE_PARTY;

    /**
     * The feature id for the '<em><b>Element Node</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__ELEMENT_NODE = COLUMNS_COMPARE_INDICATOR__ELEMENT_NODE;

    /**
     * The feature id for the '<em><b>Set</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__SET = COLUMNS_COMPARE_INDICATOR__SET;

    /**
     * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__RENDERED_OBJECT = COLUMNS_COMPARE_INDICATOR__RENDERED_OBJECT;

    /**
     * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__VOCABULARY_ELEMENT = COLUMNS_COMPARE_INDICATOR__VOCABULARY_ELEMENT;

    /**
     * The feature id for the '<em><b>Measurement</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__MEASUREMENT = COLUMNS_COMPARE_INDICATOR__MEASUREMENT;

    /**
     * The feature id for the '<em><b>Change Request</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__CHANGE_REQUEST = COLUMNS_COMPARE_INDICATOR__CHANGE_REQUEST;

    /**
     * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__DASDL_PROPERTY = COLUMNS_COMPARE_INDICATOR__DASDL_PROPERTY;

    /**
     * The feature id for the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__COUNT = COLUMNS_COMPARE_INDICATOR__COUNT;

    /**
     * The feature id for the '<em><b>Null Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__NULL_COUNT = COLUMNS_COMPARE_INDICATOR__NULL_COUNT;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__PARAMETERS = COLUMNS_COMPARE_INDICATOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Analyzed Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__ANALYZED_ELEMENT = COLUMNS_COMPARE_INDICATOR__ANALYZED_ELEMENT;

    /**
     * The feature id for the '<em><b>Datamining Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__DATAMINING_TYPE = COLUMNS_COMPARE_INDICATOR__DATAMINING_TYPE;

    /**
     * The feature id for the '<em><b>Indicator Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__INDICATOR_DEFINITION = COLUMNS_COMPARE_INDICATOR__INDICATOR_DEFINITION;

    /**
     * The feature id for the '<em><b>Instantiated Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__INSTANTIATED_EXPRESSIONS = COLUMNS_COMPARE_INDICATOR__INSTANTIATED_EXPRESSIONS;

    /**
     * The feature id for the '<em><b>Matching Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__MATCHING_VALUE_COUNT = COLUMNS_COMPARE_INDICATOR__MATCHING_VALUE_COUNT;

    /**
     * The feature id for the '<em><b>Not Matching Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__NOT_MATCHING_VALUE_COUNT = COLUMNS_COMPARE_INDICATOR__NOT_MATCHING_VALUE_COUNT;

    /**
     * The feature id for the '<em><b>Column Set A</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__COLUMN_SET_A = COLUMNS_COMPARE_INDICATOR__COLUMN_SET_A;

    /**
     * The feature id for the '<em><b>Column Set B</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR__COLUMN_SET_B = COLUMNS_COMPARE_INDICATOR__COLUMN_SET_B;

    /**
     * The number of structural features of the '<em>Value Matching Indicator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VALUE_MATCHING_INDICATOR_FEATURE_COUNT = COLUMNS_COMPARE_INDICATOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '{@link org.talend.dataquality.indicators.columnset.impl.RowMatchingIndicatorImpl <em>Row Matching Indicator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.dataquality.indicators.columnset.impl.RowMatchingIndicatorImpl
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getRowMatchingIndicator()
     * @generated
     */
    int ROW_MATCHING_INDICATOR = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__NAME = COLUMNS_COMPARE_INDICATOR__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__VISIBILITY = COLUMNS_COMPARE_INDICATOR__VISIBILITY;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__CLIENT_DEPENDENCY = COLUMNS_COMPARE_INDICATOR__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__SUPPLIER_DEPENDENCY = COLUMNS_COMPARE_INDICATOR__SUPPLIER_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__CONSTRAINT = COLUMNS_COMPARE_INDICATOR__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__NAMESPACE = COLUMNS_COMPARE_INDICATOR__NAMESPACE;

    /**
     * The feature id for the '<em><b>Importer</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__IMPORTER = COLUMNS_COMPARE_INDICATOR__IMPORTER;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__STEREOTYPE = COLUMNS_COMPARE_INDICATOR__STEREOTYPE;

    /**
     * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__TAGGED_VALUE = COLUMNS_COMPARE_INDICATOR__TAGGED_VALUE;

    /**
     * The feature id for the '<em><b>Document</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__DOCUMENT = COLUMNS_COMPARE_INDICATOR__DOCUMENT;

    /**
     * The feature id for the '<em><b>Description</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__DESCRIPTION = COLUMNS_COMPARE_INDICATOR__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__RESPONSIBLE_PARTY = COLUMNS_COMPARE_INDICATOR__RESPONSIBLE_PARTY;

    /**
     * The feature id for the '<em><b>Element Node</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__ELEMENT_NODE = COLUMNS_COMPARE_INDICATOR__ELEMENT_NODE;

    /**
     * The feature id for the '<em><b>Set</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__SET = COLUMNS_COMPARE_INDICATOR__SET;

    /**
     * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__RENDERED_OBJECT = COLUMNS_COMPARE_INDICATOR__RENDERED_OBJECT;

    /**
     * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__VOCABULARY_ELEMENT = COLUMNS_COMPARE_INDICATOR__VOCABULARY_ELEMENT;

    /**
     * The feature id for the '<em><b>Measurement</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__MEASUREMENT = COLUMNS_COMPARE_INDICATOR__MEASUREMENT;

    /**
     * The feature id for the '<em><b>Change Request</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__CHANGE_REQUEST = COLUMNS_COMPARE_INDICATOR__CHANGE_REQUEST;

    /**
     * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__DASDL_PROPERTY = COLUMNS_COMPARE_INDICATOR__DASDL_PROPERTY;

    /**
     * The feature id for the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__COUNT = COLUMNS_COMPARE_INDICATOR__COUNT;

    /**
     * The feature id for the '<em><b>Null Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__NULL_COUNT = COLUMNS_COMPARE_INDICATOR__NULL_COUNT;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__PARAMETERS = COLUMNS_COMPARE_INDICATOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Analyzed Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__ANALYZED_ELEMENT = COLUMNS_COMPARE_INDICATOR__ANALYZED_ELEMENT;

    /**
     * The feature id for the '<em><b>Datamining Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__DATAMINING_TYPE = COLUMNS_COMPARE_INDICATOR__DATAMINING_TYPE;

    /**
     * The feature id for the '<em><b>Indicator Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__INDICATOR_DEFINITION = COLUMNS_COMPARE_INDICATOR__INDICATOR_DEFINITION;

    /**
     * The feature id for the '<em><b>Instantiated Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__INSTANTIATED_EXPRESSIONS = COLUMNS_COMPARE_INDICATOR__INSTANTIATED_EXPRESSIONS;

    /**
     * The feature id for the '<em><b>Matching Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__MATCHING_VALUE_COUNT = COLUMNS_COMPARE_INDICATOR__MATCHING_VALUE_COUNT;

    /**
     * The feature id for the '<em><b>Not Matching Value Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__NOT_MATCHING_VALUE_COUNT = COLUMNS_COMPARE_INDICATOR__NOT_MATCHING_VALUE_COUNT;

    /**
     * The feature id for the '<em><b>Column Set A</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__COLUMN_SET_A = COLUMNS_COMPARE_INDICATOR__COLUMN_SET_A;

    /**
     * The feature id for the '<em><b>Column Set B</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR__COLUMN_SET_B = COLUMNS_COMPARE_INDICATOR__COLUMN_SET_B;

    /**
     * The number of structural features of the '<em>Row Matching Indicator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ROW_MATCHING_INDICATOR_FEATURE_COUNT = COLUMNS_COMPARE_INDICATOR_FEATURE_COUNT + 0;


    /**
     * The meta object id for the '{@link org.talend.dataquality.indicators.columnset.impl.ColumnSetMultiValueIndicatorImpl <em>Column Set Multi Value Indicator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnSetMultiValueIndicatorImpl
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getColumnSetMultiValueIndicator()
     * @generated
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR = 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__NAME = IndicatorsPackage.INDICATOR__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__VISIBILITY = IndicatorsPackage.INDICATOR__VISIBILITY;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__CLIENT_DEPENDENCY = IndicatorsPackage.INDICATOR__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__SUPPLIER_DEPENDENCY = IndicatorsPackage.INDICATOR__SUPPLIER_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__CONSTRAINT = IndicatorsPackage.INDICATOR__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__NAMESPACE = IndicatorsPackage.INDICATOR__NAMESPACE;

    /**
     * The feature id for the '<em><b>Importer</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__IMPORTER = IndicatorsPackage.INDICATOR__IMPORTER;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__STEREOTYPE = IndicatorsPackage.INDICATOR__STEREOTYPE;

    /**
     * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__TAGGED_VALUE = IndicatorsPackage.INDICATOR__TAGGED_VALUE;

    /**
     * The feature id for the '<em><b>Document</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__DOCUMENT = IndicatorsPackage.INDICATOR__DOCUMENT;

    /**
     * The feature id for the '<em><b>Description</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__DESCRIPTION = IndicatorsPackage.INDICATOR__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__RESPONSIBLE_PARTY = IndicatorsPackage.INDICATOR__RESPONSIBLE_PARTY;

    /**
     * The feature id for the '<em><b>Element Node</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__ELEMENT_NODE = IndicatorsPackage.INDICATOR__ELEMENT_NODE;

    /**
     * The feature id for the '<em><b>Set</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__SET = IndicatorsPackage.INDICATOR__SET;

    /**
     * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__RENDERED_OBJECT = IndicatorsPackage.INDICATOR__RENDERED_OBJECT;

    /**
     * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__VOCABULARY_ELEMENT = IndicatorsPackage.INDICATOR__VOCABULARY_ELEMENT;

    /**
     * The feature id for the '<em><b>Measurement</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__MEASUREMENT = IndicatorsPackage.INDICATOR__MEASUREMENT;

    /**
     * The feature id for the '<em><b>Change Request</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__CHANGE_REQUEST = IndicatorsPackage.INDICATOR__CHANGE_REQUEST;

    /**
     * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__DASDL_PROPERTY = IndicatorsPackage.INDICATOR__DASDL_PROPERTY;

    /**
     * The feature id for the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__COUNT = IndicatorsPackage.INDICATOR__COUNT;

    /**
     * The feature id for the '<em><b>Null Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__NULL_COUNT = IndicatorsPackage.INDICATOR__NULL_COUNT;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__PARAMETERS = IndicatorsPackage.INDICATOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Analyzed Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__ANALYZED_ELEMENT = IndicatorsPackage.INDICATOR__ANALYZED_ELEMENT;

    /**
     * The feature id for the '<em><b>Datamining Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__DATAMINING_TYPE = IndicatorsPackage.INDICATOR__DATAMINING_TYPE;

    /**
     * The feature id for the '<em><b>Indicator Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__INDICATOR_DEFINITION = IndicatorsPackage.INDICATOR__INDICATOR_DEFINITION;

    /**
     * The feature id for the '<em><b>Instantiated Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__INSTANTIATED_EXPRESSIONS = IndicatorsPackage.INDICATOR__INSTANTIATED_EXPRESSIONS;

    /**
     * The feature id for the '<em><b>Analyzed Columns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__ANALYZED_COLUMNS = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>List Rows</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__LIST_ROWS = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Numeric Functions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__NUMERIC_FUNCTIONS = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Nominal Columns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__NOMINAL_COLUMNS = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Numeric Columns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__NUMERIC_COLUMNS = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Column Headers</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR__COLUMN_HEADERS = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Column Set Multi Value Indicator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COLUMN_SET_MULTI_VALUE_INDICATOR_FEATURE_COUNT = IndicatorsPackage.INDICATOR_FEATURE_COUNT + 6;


    /**
     * The meta object id for the '{@link org.talend.dataquality.indicators.columnset.impl.CountAvgNullIndicatorImpl <em>Count Avg Null Indicator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.talend.dataquality.indicators.columnset.impl.CountAvgNullIndicatorImpl
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getCountAvgNullIndicator()
     * @generated
     */
    int COUNT_AVG_NULL_INDICATOR = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__NAME = COLUMN_SET_MULTI_VALUE_INDICATOR__NAME;

    /**
     * The feature id for the '<em><b>Visibility</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__VISIBILITY = COLUMN_SET_MULTI_VALUE_INDICATOR__VISIBILITY;

    /**
     * The feature id for the '<em><b>Client Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__CLIENT_DEPENDENCY = COLUMN_SET_MULTI_VALUE_INDICATOR__CLIENT_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Supplier Dependency</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__SUPPLIER_DEPENDENCY = COLUMN_SET_MULTI_VALUE_INDICATOR__SUPPLIER_DEPENDENCY;

    /**
     * The feature id for the '<em><b>Constraint</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__CONSTRAINT = COLUMN_SET_MULTI_VALUE_INDICATOR__CONSTRAINT;

    /**
     * The feature id for the '<em><b>Namespace</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__NAMESPACE = COLUMN_SET_MULTI_VALUE_INDICATOR__NAMESPACE;

    /**
     * The feature id for the '<em><b>Importer</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__IMPORTER = COLUMN_SET_MULTI_VALUE_INDICATOR__IMPORTER;

    /**
     * The feature id for the '<em><b>Stereotype</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__STEREOTYPE = COLUMN_SET_MULTI_VALUE_INDICATOR__STEREOTYPE;

    /**
     * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__TAGGED_VALUE = COLUMN_SET_MULTI_VALUE_INDICATOR__TAGGED_VALUE;

    /**
     * The feature id for the '<em><b>Document</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__DOCUMENT = COLUMN_SET_MULTI_VALUE_INDICATOR__DOCUMENT;

    /**
     * The feature id for the '<em><b>Description</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__DESCRIPTION = COLUMN_SET_MULTI_VALUE_INDICATOR__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Responsible Party</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__RESPONSIBLE_PARTY = COLUMN_SET_MULTI_VALUE_INDICATOR__RESPONSIBLE_PARTY;

    /**
     * The feature id for the '<em><b>Element Node</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__ELEMENT_NODE = COLUMN_SET_MULTI_VALUE_INDICATOR__ELEMENT_NODE;

    /**
     * The feature id for the '<em><b>Set</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__SET = COLUMN_SET_MULTI_VALUE_INDICATOR__SET;

    /**
     * The feature id for the '<em><b>Rendered Object</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__RENDERED_OBJECT = COLUMN_SET_MULTI_VALUE_INDICATOR__RENDERED_OBJECT;

    /**
     * The feature id for the '<em><b>Vocabulary Element</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__VOCABULARY_ELEMENT = COLUMN_SET_MULTI_VALUE_INDICATOR__VOCABULARY_ELEMENT;

    /**
     * The feature id for the '<em><b>Measurement</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__MEASUREMENT = COLUMN_SET_MULTI_VALUE_INDICATOR__MEASUREMENT;

    /**
     * The feature id for the '<em><b>Change Request</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__CHANGE_REQUEST = COLUMN_SET_MULTI_VALUE_INDICATOR__CHANGE_REQUEST;

    /**
     * The feature id for the '<em><b>Dasdl Property</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__DASDL_PROPERTY = COLUMN_SET_MULTI_VALUE_INDICATOR__DASDL_PROPERTY;

    /**
     * The feature id for the '<em><b>Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__COUNT = COLUMN_SET_MULTI_VALUE_INDICATOR__COUNT;

    /**
     * The feature id for the '<em><b>Null Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__NULL_COUNT = COLUMN_SET_MULTI_VALUE_INDICATOR__NULL_COUNT;

    /**
     * The feature id for the '<em><b>Parameters</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__PARAMETERS = COLUMN_SET_MULTI_VALUE_INDICATOR__PARAMETERS;

    /**
     * The feature id for the '<em><b>Analyzed Element</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__ANALYZED_ELEMENT = COLUMN_SET_MULTI_VALUE_INDICATOR__ANALYZED_ELEMENT;

    /**
     * The feature id for the '<em><b>Datamining Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__DATAMINING_TYPE = COLUMN_SET_MULTI_VALUE_INDICATOR__DATAMINING_TYPE;

    /**
     * The feature id for the '<em><b>Indicator Definition</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__INDICATOR_DEFINITION = COLUMN_SET_MULTI_VALUE_INDICATOR__INDICATOR_DEFINITION;

    /**
     * The feature id for the '<em><b>Instantiated Expressions</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__INSTANTIATED_EXPRESSIONS = COLUMN_SET_MULTI_VALUE_INDICATOR__INSTANTIATED_EXPRESSIONS;

    /**
     * The feature id for the '<em><b>Analyzed Columns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__ANALYZED_COLUMNS = COLUMN_SET_MULTI_VALUE_INDICATOR__ANALYZED_COLUMNS;

    /**
     * The feature id for the '<em><b>List Rows</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__LIST_ROWS = COLUMN_SET_MULTI_VALUE_INDICATOR__LIST_ROWS;

    /**
     * The feature id for the '<em><b>Numeric Functions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__NUMERIC_FUNCTIONS = COLUMN_SET_MULTI_VALUE_INDICATOR__NUMERIC_FUNCTIONS;

    /**
     * The feature id for the '<em><b>Nominal Columns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__NOMINAL_COLUMNS = COLUMN_SET_MULTI_VALUE_INDICATOR__NOMINAL_COLUMNS;

    /**
     * The feature id for the '<em><b>Numeric Columns</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__NUMERIC_COLUMNS = COLUMN_SET_MULTI_VALUE_INDICATOR__NUMERIC_COLUMNS;

    /**
     * The feature id for the '<em><b>Column Headers</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR__COLUMN_HEADERS = COLUMN_SET_MULTI_VALUE_INDICATOR__COLUMN_HEADERS;

    /**
     * The number of structural features of the '<em>Count Avg Null Indicator</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COUNT_AVG_NULL_INDICATOR_FEATURE_COUNT = COLUMN_SET_MULTI_VALUE_INDICATOR_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '<em>List Object</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.List
     * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getListObject()
     * @generated
     */
    int LIST_OBJECT = 5;


    /**
     * Returns the meta object for class '{@link org.talend.dataquality.indicators.columnset.ColumnsCompareIndicator <em>Columns Compare Indicator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Columns Compare Indicator</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnsCompareIndicator
     * @generated
     */
    EClass getColumnsCompareIndicator();

    /**
     * Returns the meta object for the reference list '{@link org.talend.dataquality.indicators.columnset.ColumnsCompareIndicator#getColumnSetA <em>Column Set A</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Column Set A</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnsCompareIndicator#getColumnSetA()
     * @see #getColumnsCompareIndicator()
     * @generated
     */
    EReference getColumnsCompareIndicator_ColumnSetA();

    /**
     * Returns the meta object for the reference list '{@link org.talend.dataquality.indicators.columnset.ColumnsCompareIndicator#getColumnSetB <em>Column Set B</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Column Set B</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnsCompareIndicator#getColumnSetB()
     * @see #getColumnsCompareIndicator()
     * @generated
     */
    EReference getColumnsCompareIndicator_ColumnSetB();

    /**
     * Returns the meta object for class '{@link org.talend.dataquality.indicators.columnset.ValueMatchingIndicator <em>Value Matching Indicator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Value Matching Indicator</em>'.
     * @see org.talend.dataquality.indicators.columnset.ValueMatchingIndicator
     * @generated
     */
    EClass getValueMatchingIndicator();

    /**
     * Returns the meta object for class '{@link org.talend.dataquality.indicators.columnset.RowMatchingIndicator <em>Row Matching Indicator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Row Matching Indicator</em>'.
     * @see org.talend.dataquality.indicators.columnset.RowMatchingIndicator
     * @generated
     */
    EClass getRowMatchingIndicator();

    /**
     * Returns the meta object for class '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator <em>Column Set Multi Value Indicator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Column Set Multi Value Indicator</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator
     * @generated
     */
    EClass getColumnSetMultiValueIndicator();

    /**
     * Returns the meta object for the reference list '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getAnalyzedColumns <em>Analyzed Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Analyzed Columns</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getAnalyzedColumns()
     * @see #getColumnSetMultiValueIndicator()
     * @generated
     */
    EReference getColumnSetMultiValueIndicator_AnalyzedColumns();

    /**
     * Returns the meta object for the attribute '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getListRows <em>List Rows</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>List Rows</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getListRows()
     * @see #getColumnSetMultiValueIndicator()
     * @generated
     */
    EAttribute getColumnSetMultiValueIndicator_ListRows();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getNumericFunctions <em>Numeric Functions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Numeric Functions</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getNumericFunctions()
     * @see #getColumnSetMultiValueIndicator()
     * @generated
     */
    EAttribute getColumnSetMultiValueIndicator_NumericFunctions();

    /**
     * Returns the meta object for the reference list '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getNominalColumns <em>Nominal Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Nominal Columns</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getNominalColumns()
     * @see #getColumnSetMultiValueIndicator()
     * @generated
     */
    EReference getColumnSetMultiValueIndicator_NominalColumns();

    /**
     * Returns the meta object for the reference list '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getNumericColumns <em>Numeric Columns</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Numeric Columns</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getNumericColumns()
     * @see #getColumnSetMultiValueIndicator()
     * @generated
     */
    EReference getColumnSetMultiValueIndicator_NumericColumns();

    /**
     * Returns the meta object for the attribute list '{@link org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getColumnHeaders <em>Column Headers</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Column Headers</em>'.
     * @see org.talend.dataquality.indicators.columnset.ColumnSetMultiValueIndicator#getColumnHeaders()
     * @see #getColumnSetMultiValueIndicator()
     * @generated
     */
    EAttribute getColumnSetMultiValueIndicator_ColumnHeaders();

    /**
     * Returns the meta object for class '{@link org.talend.dataquality.indicators.columnset.CountAvgNullIndicator <em>Count Avg Null Indicator</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Count Avg Null Indicator</em>'.
     * @see org.talend.dataquality.indicators.columnset.CountAvgNullIndicator
     * @generated
     */
    EClass getCountAvgNullIndicator();

    /**
     * Returns the meta object for data type '{@link java.util.List <em>List Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>List Object</em>'.
     * @see java.util.List
     * @model instanceClass="java.util.List<java.lang.Object>"
     * @generated
     */
    EDataType getListObject();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ColumnsetFactory getColumnsetFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link org.talend.dataquality.indicators.columnset.impl.ColumnsCompareIndicatorImpl <em>Columns Compare Indicator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsCompareIndicatorImpl
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getColumnsCompareIndicator()
         * @generated
         */
        EClass COLUMNS_COMPARE_INDICATOR = eINSTANCE.getColumnsCompareIndicator();

        /**
         * The meta object literal for the '<em><b>Column Set A</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COLUMNS_COMPARE_INDICATOR__COLUMN_SET_A = eINSTANCE.getColumnsCompareIndicator_ColumnSetA();

        /**
         * The meta object literal for the '<em><b>Column Set B</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COLUMNS_COMPARE_INDICATOR__COLUMN_SET_B = eINSTANCE.getColumnsCompareIndicator_ColumnSetB();

        /**
         * The meta object literal for the '{@link org.talend.dataquality.indicators.columnset.impl.ValueMatchingIndicatorImpl <em>Value Matching Indicator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.dataquality.indicators.columnset.impl.ValueMatchingIndicatorImpl
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getValueMatchingIndicator()
         * @generated
         */
        EClass VALUE_MATCHING_INDICATOR = eINSTANCE.getValueMatchingIndicator();

        /**
         * The meta object literal for the '{@link org.talend.dataquality.indicators.columnset.impl.RowMatchingIndicatorImpl <em>Row Matching Indicator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.dataquality.indicators.columnset.impl.RowMatchingIndicatorImpl
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getRowMatchingIndicator()
         * @generated
         */
        EClass ROW_MATCHING_INDICATOR = eINSTANCE.getRowMatchingIndicator();

        /**
         * The meta object literal for the '{@link org.talend.dataquality.indicators.columnset.impl.ColumnSetMultiValueIndicatorImpl <em>Column Set Multi Value Indicator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnSetMultiValueIndicatorImpl
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getColumnSetMultiValueIndicator()
         * @generated
         */
        EClass COLUMN_SET_MULTI_VALUE_INDICATOR = eINSTANCE.getColumnSetMultiValueIndicator();

        /**
         * The meta object literal for the '<em><b>Analyzed Columns</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COLUMN_SET_MULTI_VALUE_INDICATOR__ANALYZED_COLUMNS = eINSTANCE.getColumnSetMultiValueIndicator_AnalyzedColumns();

        /**
         * The meta object literal for the '<em><b>List Rows</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_SET_MULTI_VALUE_INDICATOR__LIST_ROWS = eINSTANCE.getColumnSetMultiValueIndicator_ListRows();

        /**
         * The meta object literal for the '<em><b>Numeric Functions</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_SET_MULTI_VALUE_INDICATOR__NUMERIC_FUNCTIONS = eINSTANCE.getColumnSetMultiValueIndicator_NumericFunctions();

        /**
         * The meta object literal for the '<em><b>Nominal Columns</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COLUMN_SET_MULTI_VALUE_INDICATOR__NOMINAL_COLUMNS = eINSTANCE.getColumnSetMultiValueIndicator_NominalColumns();

        /**
         * The meta object literal for the '<em><b>Numeric Columns</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COLUMN_SET_MULTI_VALUE_INDICATOR__NUMERIC_COLUMNS = eINSTANCE.getColumnSetMultiValueIndicator_NumericColumns();

        /**
         * The meta object literal for the '<em><b>Column Headers</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COLUMN_SET_MULTI_VALUE_INDICATOR__COLUMN_HEADERS = eINSTANCE.getColumnSetMultiValueIndicator_ColumnHeaders();

        /**
         * The meta object literal for the '{@link org.talend.dataquality.indicators.columnset.impl.CountAvgNullIndicatorImpl <em>Count Avg Null Indicator</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.talend.dataquality.indicators.columnset.impl.CountAvgNullIndicatorImpl
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getCountAvgNullIndicator()
         * @generated
         */
        EClass COUNT_AVG_NULL_INDICATOR = eINSTANCE.getCountAvgNullIndicator();

        /**
         * The meta object literal for the '<em>List Object</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.List
         * @see org.talend.dataquality.indicators.columnset.impl.ColumnsetPackageImpl#getListObject()
         * @generated
         */
        EDataType LIST_OBJECT = eINSTANCE.getListObject();

    }

} //ColumnsetPackage
