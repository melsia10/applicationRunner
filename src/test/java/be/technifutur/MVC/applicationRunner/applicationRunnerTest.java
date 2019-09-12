package be.technifutur.MVC.applicationRunner;


import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class applicationRunnerTest {
    private boolean called = false;
    private InteractiveRunner runner;
    private InteractiveApplication applicationMock;
    private Environment environmentMock;

    @BeforeEach
    public void init() {
        this.runner = new InteractiveRunner();
        this.applicationMock = (InteractiveApplication)EasyMock.createMock(InteractiveApplication.class);
        this.runner.setApplication(this.applicationMock);
        this.environmentMock = (Environment)EasyMock.createMock(Environment.class);
        this.runner.setEnvironment(this.environmentMock);
    }

    @Test
    public void testSetApplicationNotNull() {
        Assertions.assertAll(new Executable[]{() -> {
            Assertions.assertNotNull(this.runner.getApplication());
        }, () -> {
            Assertions.assertSame(this.applicationMock, this.runner.getApplication());
        }});
    }

    @Test
    public void testRunCallsStart() {
        this.applicationMock.start();
        EasyMock.expect(this.applicationMock.isFinish()).andReturn(true);
        EasyMock.expect(this.applicationMock.hasLastScreen()).andReturn(false);
        this.applicationMock.stop();
        EasyMock.replay(new Object[]{this.applicationMock});
        this.runner.run();
        EasyMock.verify(new Object[]{this.applicationMock});
    }

    @Test
    public void testGetScreenReturnTest() {
        this.applicationMock.start();
        EasyMock.expect(this.applicationMock.isFinish()).andReturn(false);
        EasyMock.expect(this.applicationMock.getScreen()).andReturn(new StringBuilder("Comment vous appelez-vous?"));
        this.environmentMock.print("Comment vous appelez-vous?");
        EasyMock.expect(this.environmentMock.nextLine()).andReturn("Test");
        this.applicationMock.newInput("Test");
        EasyMock.expect(this.applicationMock.isFinish()).andReturn(true);
        EasyMock.expect(this.applicationMock.hasLastScreen()).andReturn(false);
        this.applicationMock.stop();
        EasyMock.replay(new Object[]{this.applicationMock, this.environmentMock});
        this.runner.run();
        EasyMock.verify(new Object[]{this.environmentMock, this.applicationMock});
    }
   }
