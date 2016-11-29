package com.example.encryption.abe.cpabe.rw13;

import cn.edu.buaa.crypto.access.lsss.lw10.LSSSLW10Engine;
import cn.edu.buaa.crypto.access.tree.AccessTreeEngine;
import cn.edu.buaa.crypto.encryption.abe.cpabe.CPABEEngine;
import cn.edu.buaa.crypto.encryption.abe.cpabe.rw13.CPABERW13Engine;
import com.example.TestUtils;
import com.example.encryption.abe.cpabe.CPABEEngineJUnitTest;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import junit.framework.TestCase;

/**
 * Created by Weiran Liu on 2016/11/29.
 *
 * Rouselakis-Waters CP-ABE engine JUnit test.
 */
public class CPABERW13EngineJUnitTest extends TestCase {
    private CPABEEngine engine;
    private CPABEEngineJUnitTest engineJUnitTest;

    public void setUp() {
        this.engine = CPABERW13Engine.getInstance();
        this.engineJUnitTest = new CPABEEngineJUnitTest(engine);
    }

    public void testUsingAccessTree() {
        System.out.println("Test " + engine.getEngineName() + " using " + AccessTreeEngine.SCHEME_NAME);
        engine.setAccessControlEngine(AccessTreeEngine.getInstance());
        engineJUnitTest.runAllTests(PairingFactory.getPairingParameters(TestUtils.TEST_PAIRING_PARAMETERS_PATH_a_80_256));
    }

    public void testUsingLSSS() {
        System.out.println("Test " + engine.getEngineName() + " using " + LSSSLW10Engine.SCHEME_NAME);
        engine.setAccessControlEngine(LSSSLW10Engine.getInstance());
        engineJUnitTest.runAllTests(PairingFactory.getPairingParameters(TestUtils.TEST_PAIRING_PARAMETERS_PATH_a_80_256));
    }
}